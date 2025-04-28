package com.example.atividade3.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosSetorDTO {
    private Long id;
    private String nome;
    private List<FuncionarioResumoDTO> funcionarios;
}
