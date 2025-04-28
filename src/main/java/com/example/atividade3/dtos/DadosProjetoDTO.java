package com.example.atividade3.dtos;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosProjetoDTO {
    private Long id;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private List<FuncionarioResumoDTO> funcionarios;
    
    public DadosProjetoDTO(Long id, String descricao, LocalDate dataInicio, LocalDate dataFim) {
        this(id, descricao, dataInicio, dataFim, Collections.emptyList());
    }
}
