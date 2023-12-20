package com.crud.cliente.dto.telefone;

import com.crud.cliente.data.telefone.Telefone;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TelefoneMapper {

    Telefone fromDTO(TelefoneDTO telefoneDTO);

    TelefoneDTO toDTO(Telefone telefone);

}