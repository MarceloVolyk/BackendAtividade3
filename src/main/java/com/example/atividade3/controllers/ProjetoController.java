package com.example.atividade3.controllers;

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
import com.example.atividade3.dtos.ProjetoDTO;
import com.example.atividade3.services.ProjetoService;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

	@Autowired
	private ProjetoService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<DadosProjetoDTO> buscarProjetoPorId(@PathVariable Long id) {
	    DadosProjetoDTO projetoDTO = service.buscarProjetoComFuncionarios(id);
	    return ResponseEntity.ok(projetoDTO);
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionar(@RequestBody ProjetoDTO projetoDTO) {
        service.salvarProjeto(projetoDTO);
    }
	
	@PostMapping("/{idProjeto}/funcionarios/{idFuncionario}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void vincularFuncionario(
            @PathVariable("idProjeto") Integer idProjeto,
            @PathVariable("idFuncionario") Integer idFuncionario) {
        
        service.vincularFuncionario(
            idProjeto.longValue(), 
            idFuncionario.longValue()
        );
    }
}
