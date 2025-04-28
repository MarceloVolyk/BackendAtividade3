package com.example.atividade3.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.atividade3.dtos.DadosProjetoDTO;
import com.example.atividade3.dtos.FuncionarioDTO;
import com.example.atividade3.entities.Funcionario;
import com.example.atividade3.entities.Projeto;
import com.example.atividade3.entities.Setor;
import com.example.atividade3.exceptions.SetorNotFoundException;
import com.example.atividade3.repositories.FuncionarioRepository;
import com.example.atividade3.repositories.ProjetoRepository;
import com.example.atividade3.repositories.SetorRepository;

import jakarta.transaction.Transactional;

public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;
	@Autowired
	private SetorRepository setRepo;
	@Autowired
	private ProjetoRepository projRepo;
	
	 @Transactional
	    public void salvarFuncionario(FuncionarioDTO funcionarioDTO) {
	        Setor setor = setRepo.findById(funcionarioDTO.getSetorId())
	                .orElseThrow(() -> new SetorNotFoundException("Setor não encontrado"));

	        Funcionario funcionario = new Funcionario();
	        funcionario.setNome(funcionarioDTO.getNome());
	        funcionario.setSetor(setor);

	        repository.save(funcionario);
	    }
	 
	 public List<DadosProjetoDTO> buscarProjetosPorFuncionario(Long idFuncionario) {
		    
		    List<Projeto> projetos = projRepo.findByFuncionariosId(idFuncionario);
		    
		    return projetos.stream()
		            .map(this::converterParaDadosProjetoDTO)
		            .toList();
		}

		private DadosProjetoDTO converterParaDadosProjetoDTO(Projeto projeto) {
		    return new DadosProjetoDTO(
		            projeto.getId(),
		            projeto.getDescricao(),
		            projeto.getDataInicio(),
		            projeto.getDataFim(),
		            
		            Collections.emptyList()
		    );
		}
}
