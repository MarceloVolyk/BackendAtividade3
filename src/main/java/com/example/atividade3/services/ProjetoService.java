package com.example.atividade3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.atividade3.dtos.DadosProjetoDTO;
import com.example.atividade3.dtos.FuncionarioResumoDTO;
import com.example.atividade3.dtos.ProjetoDTO;
import com.example.atividade3.entities.Funcionario;
import com.example.atividade3.entities.Projeto;
import com.example.atividade3.exceptions.FuncionarioNotFoundException;
import com.example.atividade3.exceptions.ProjetoNotFoundException;
import com.example.atividade3.repositories.FuncionarioRepository;
import com.example.atividade3.repositories.ProjetoRepository;

import jakarta.transaction.Transactional;

public class ProjetoService {

	@Autowired
	private ProjetoRepository repository;
	@Autowired
	private FuncionarioRepository funcRepo;
	
	 @Transactional
	    public void salvarProjeto(ProjetoDTO projetoDTO) {
	        Projeto projeto = new Projeto();
	        projeto.setDescricao(projetoDTO.getDescricao());
	        projeto.setDataInicio(projetoDTO.getDataInicio());
	        projeto.setDataFim(projetoDTO.getDataFim());
	        
	        repository.save(projeto);
	    }
	 
	 public DadosProjetoDTO buscarProjetoComFuncionarios(Long id) {
		    Projeto projeto = repository.findByIdWithFuncionarios(id)
		        .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
		    
		    List<FuncionarioResumoDTO> funcionariosDTO = projeto.getFuncionarios().stream()
		        .map(func -> new FuncionarioResumoDTO(
		            func.getId(),
		            func.getNome(),
		            func.getSetor() != null ? func.getSetor().getNome() : null))
		        .toList();
		    
		    return new DadosProjetoDTO(
		        projeto.getId(),
		        projeto.getDescricao(),
		        projeto.getDataInicio(),
		        projeto.getDataFim(),
		        funcionariosDTO);
		}
	 
	 @Transactional
	    public void vincularFuncionario(Long idProjeto, Long idFuncionario) {
	        Projeto projeto = repository.findById(idProjeto)
	                .orElseThrow(() -> new ProjetoNotFoundException("Projeto não encontrado"));
	        
	        Funcionario funcionario = funcRepo.findById(idFuncionario)
	                .orElseThrow(() -> new FuncionarioNotFoundException("Funcionario não encontrado"));
	        
	        projeto.getFuncionarios().add(funcionario);
	        repository.save(projeto);
	    }
}
