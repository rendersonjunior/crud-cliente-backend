package com.crud.cliente.service.cliente;

import com.crud.cliente.data.cliente.Cliente;

import java.util.List;

public interface IClienteService {
    void validate(Cliente cliente);

    List<Cliente> buscarTodosClientes();

    Cliente buscarClientePorId(Long id);

    Cliente salvarCliente(final Cliente cliente);

}
