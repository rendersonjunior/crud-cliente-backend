package com.crud.cliente.data.cliente;

import com.crud.cliente.data.telefone.Telefone;
import com.crud.cliente.dto.cliente.ClienteDTO;
import com.crud.cliente.dto.telefone.TelefoneDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Cliente {

    private Long id;

    @NotBlank(message = "O campo nome não pode estar em branco")
    @Size(min = 10, message = "O campo nome deve ter no minimo 10 caracteres")
    private String nome;

    private String cpf;
    private String endereco;
    private String bairro;
    private List<Telefone> telefones;

    public Cliente(Long id, String nome, String cpf, String endereco, String bairro) {
    }

    public Cliente fromDTO(ClienteDTO clienteDTO) {
        if (clienteDTO == null) {
            return null;
        } else {
            Cliente cliente = new Cliente();
            cliente.setNome(clienteDTO.nome());
            cliente.setCpf(clienteDTO.cpf());
            cliente.setEndereco(clienteDTO.endereco());
            cliente.setBairro(clienteDTO.bairro());
            cliente.setTelefones(this.telefoneDTOListToTelefoneList(clienteDTO.telefones()));
            return cliente;
        }
    }

    public ClienteDTO toDTO(Cliente cliente) {
        if (cliente == null) {
            return null;
        } else {
            String nome = null;
            String cpf = null;
            String endereco = null;
            String bairro = null;
            List<TelefoneDTO> telefones = null;
            nome = cliente.getNome();
            cpf = cliente.getCpf();
            endereco = cliente.getEndereco();
            bairro = cliente.getBairro();
            telefones = this.telefoneListToTelefoneDTOList(cliente.getTelefones());
            ClienteDTO clienteDTO = new ClienteDTO(nome, cpf, endereco, bairro, telefones);
            return clienteDTO;
        }
    }

    protected Telefone telefoneDTOToTelefone(TelefoneDTO telefoneDTO) {
        if (telefoneDTO == null) {
            return null;
        } else {
            Telefone telefone = new Telefone();
            telefone.setNumero(telefoneDTO.numero());
            return telefone;
        }
    }

    protected List<Telefone> telefoneDTOListToTelefoneList(List<TelefoneDTO> list) {
        if (list == null) {
            return null;
        } else {
            List<Telefone> list1 = new ArrayList(list.size());
            Iterator var3 = list.iterator();

            while (var3.hasNext()) {
                TelefoneDTO telefoneDTO = (TelefoneDTO) var3.next();
                list1.add(this.telefoneDTOToTelefone(telefoneDTO));
            }

            return list1;
        }
    }

    protected TelefoneDTO telefoneToTelefoneDTO(Telefone telefone) {
        if (telefone == null) {
            return null;
        } else {
            String numero = null;
            numero = telefone.getNumero();
            TelefoneDTO telefoneDTO = new TelefoneDTO(numero);
            return telefoneDTO;
        }
    }

    protected List<TelefoneDTO> telefoneListToTelefoneDTOList(List<Telefone> list) {
        if (list == null) {
            return null;
        } else {
            List<TelefoneDTO> list1 = new ArrayList(list.size());
            Iterator var3 = list.iterator();

            while (var3.hasNext()) {
                Telefone telefone = (Telefone) var3.next();
                list1.add(this.telefoneToTelefoneDTO(telefone));
            }

            return list1;
        }
    }
}
