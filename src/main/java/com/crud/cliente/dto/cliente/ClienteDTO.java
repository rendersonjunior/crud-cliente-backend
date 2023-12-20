package com.crud.cliente.dto.cliente;

import com.crud.cliente.dto.telefone.TelefoneDTO;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public record ClienteDTO(
        @NotBlank(message = "O campo nome não pode estar em branco")
        @Size(min = 10, message = "O campo nome deve ter no minimo 10 caracteres")
        String nome,

        @NotBlank(message = "O campo CPF não pode estar em branco")
        @Pattern(regexp = "^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}$", message = "CPF inválido")
        String cpf,
        String endereco,
        String bairro,
        @NotNull
        @Valid
        List<TelefoneDTO> telefones) {
}
