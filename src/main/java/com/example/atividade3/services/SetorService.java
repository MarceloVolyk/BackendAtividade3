package com.example.atividade3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.atividade3.dtos.DadosSetorDTO;
import com.example.atividade3.dtos.FuncionarioResumoDTO;
import com.example.atividade3.dtos.SetorDTO;
import com.example.atividade3.entities.Setor;
import com.example.atividade3.exceptions.SetorNotFoundException;
import com.example.atividade3.repositories.SetorRepository;

import jakarta.transaction.Transactional;

public class SetorService {

	@Autowired
	private SetorRepository repository;
	
	 @Transactional
	    public void salvarSetor(SetorDTO setorDTO) {
	        Setor setor = new Setor();
	        setor.setNome(setorDTO.getNome());
	        
	        repository.save(setor);
	    }
	 
	 public DadosSetorDTO buscarSetorComFuncionarios(Long idSetor) {
		    Setor setor = repository.findByIdWithFuncionarios(idSetor)
		            .orElseThrow(() -> new SetorNotFoundException("Setor não encontrado"));
		    
		    List<FuncionarioResumoDTO> funcionariosDTO = setor.getFuncionarios().stream()
		            .map(func -> new FuncionarioResumoDTO(
		                    func.getId(),
		                    func.getNome(),
		                    null)) // Não precisamos do setor novamente
		            .toList();
		    
		    return new DadosSetorDTO(
		            setor.getId(),
		            setor.getNome(),
		            funcionariosDTO);
		}
}
