package com.crud.cliente.service.cliente;

import com.crud.cliente.data.cliente.Cliente;
import com.crud.cliente.data.cliente.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService implements IClienteService {

    private final ClienteRepository clienteRepository;

    public void validate(Cliente cliente) {
        // Verificar se o nome do cliente é maior que 10 caracteres
        // Verificar se o nome já existe
    }

    @Transactional
    public Cliente salvarCliente(final Cliente cliente) {
        this.validate(cliente);
        return clienteRepository.saveCliente(cliente, cliente.getTelefones());
    }

    public List<Cliente> buscarTodosClientes() {
        return clienteRepository.findAll();
    }

}
