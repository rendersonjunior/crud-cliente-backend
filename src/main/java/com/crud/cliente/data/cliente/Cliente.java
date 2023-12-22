package com.crud.cliente.data.cliente;

import com.crud.cliente.data.telefone.Telefone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    private Long id;
    private String nome;
    private String cpf;
    private String endereco;
    private String bairro;
    private List<Telefone> telefones;

}
