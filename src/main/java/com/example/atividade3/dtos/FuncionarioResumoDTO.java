package com.example.atividade3.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioResumoDTO {
    private Long id;
    private String nome;
    private String nomeSetor; // Opcional: incluir informação do setor
}
