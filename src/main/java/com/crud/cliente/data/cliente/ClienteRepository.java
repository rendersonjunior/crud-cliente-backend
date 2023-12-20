package com.crud.cliente.data.cliente;

import com.crud.cliente.data.telefone.Telefone;

import java.util.List;

public interface ClienteRepository {

    List<Cliente> findAll();

    Cliente saveCliente(Cliente c, List<Telefone> telefones);


}
