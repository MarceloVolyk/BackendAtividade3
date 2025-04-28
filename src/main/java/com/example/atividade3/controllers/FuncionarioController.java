package com.example.atividade3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.atividade3.dtos.DadosProjetoDTO;
import com.example.atividade3.dtos.FuncionarioDTO;
import com.example.atividade3.services.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
    private FuncionarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionar(@RequestBody FuncionarioDTO funcionarioDTO) {
        service.salvarFuncionario(funcionarioDTO);
    }
    
    @GetMapping("/{idFuncionario}/projetos")
    public ResponseEntity<List<DadosProjetoDTO>> buscarProjetos(
            @PathVariable Integer idFuncionario) {
        
        List<DadosProjetoDTO> projetos = service.buscarProjetosPorFuncionario(idFuncionario.longValue());
        return ResponseEntity.ok(projetos);
    }
}
