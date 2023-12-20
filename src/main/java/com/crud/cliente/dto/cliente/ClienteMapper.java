package com.crud.cliente.dto.cliente;

import com.crud.cliente.data.cliente.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente fromDTO(ClienteDTO clienteDTO);

    ClienteDTO toDTO(Cliente cliente);


}