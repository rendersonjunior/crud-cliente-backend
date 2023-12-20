package com.crud.cliente.dto.telefone;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public record TelefoneDTO(
        @NotBlank(message = "O campo Telefone não pode estar em branco")
        @Pattern(regexp = "^\\(\\d{2}\\)\\s?\\d{4,5}-\\d{4}$", message = "Número de telefone inválido")
        String numero) {
}
