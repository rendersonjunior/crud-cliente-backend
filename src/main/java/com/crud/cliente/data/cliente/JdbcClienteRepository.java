package com.crud.cliente.data.cliente;

import com.crud.cliente.data.telefone.Telefone;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class JdbcClienteRepository implements ClienteRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Cliente> findAll() {
        final String sql = "select * from cliente";
        List<Cliente> listaCliente = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Cliente.class));

        for (Cliente cliente : listaCliente) {
            List<Telefone> telefones = buscarTelefonesPorClienteId(cliente.getId());
            cliente.setTelefones(telefones);
        }

        return listaCliente;

    }

    private List<Telefone> buscarTelefonesPorClienteId(Long clienteId) {
        String sql = "SELECT id, numero FROM telefone WHERE id_cliente = ?";

        return jdbcTemplate.query(sql, new Object[]{clienteId}, new BeanPropertyRowMapper<>(Telefone.class));
    }

    @Override
    public Cliente saveCliente(final Cliente cliente, final List<Telefone> telefones) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO cliente(nome, cpf, endereco, bairro) VALUES (?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getEndereco());
            ps.setString(4, cliente.getBairro());
            return ps;
        }, keyHolder);

        final Long idCliente = keyHolder.getKey().longValue();

        for (final Telefone telefone : telefones) {
            jdbcTemplate.update("insert into telefone(id_cliente, numero) values(?, ?)",
                    idCliente,
                    telefone.getNumero());
        }

        return cliente;
    }

}
