package com.crud.cliente.dto.telefone;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TelefoneDTO {
    @NotBlank(message = "O campo Telefone não pode estar em branco")
    @Pattern(regexp = "^\\(\\d{2}\\)\\s?\\d{4,5}-\\d{4}$", message = "Número de telefone inválido")
    private String numero;
}
