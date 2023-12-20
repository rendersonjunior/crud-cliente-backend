package com.crud.cliente.service.clienteService;

import com.crud.cliente.data.cliente.Cliente;

import java.util.List;

public interface IClienteService {
    void validate(Cliente cliente);

    List<Cliente> buscarTodosClientes();

    Cliente salvarCliente(final Cliente cliente) throws Exception;

}
