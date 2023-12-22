package com.crud.cliente.dto.cliente;

import com.crud.cliente.dto.telefone.TelefoneDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    @NotBlank(message = "O campo nome não pode estar em branco")
    @Size(min = 10, message = "O campo nome deve ter no minimo 10 caracteres")
    private String nome;

    @NotBlank(message = "O campo CPF não pode estar em branco")
    @Pattern(regexp = "^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}$", message = "CPF inválido")
    private String cpf;
    private String endereco;
    private String bairro;
    @Valid
    private List<TelefoneDTO> telefones;
}
