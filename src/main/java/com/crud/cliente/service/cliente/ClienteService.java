package com.crud.cliente.service.cliente;

import com.crud.cliente.data.cliente.Cliente;
import com.crud.cliente.data.cliente.ClienteRepository;
import com.crud.cliente.data.telefone.Telefone;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService implements IClienteService {

    private final ClienteRepository clienteRepository;

    public void validate(Cliente cliente) {
        // TODO: Não é a melhor abordagem, mas será evoluido para mandar os dados limpos (apenas numericos)
        cliente.setCpf(cliente.getCpf().replaceAll("[^0-9]", ""));
        for (Telefone telefone : cliente.getTelefones()) {
            telefone.setNumero(telefone.getNumero().replaceAll("[^0-9]", ""));
        }

        // TODO: Verificar se o nome já existe

    }

    @Transactional
    public Cliente salvarCliente(final Cliente cliente) {
        this.validate(cliente);
        return clienteRepository.saveCliente(cliente, cliente.getTelefones());
    }

    public List<Cliente> buscarTodosClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarClientePorId(Long id) {
        return clienteRepository.findById(id);
    }
}
