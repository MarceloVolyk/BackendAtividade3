package com.example.atividade3.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.atividade3.entities.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long>{

	 @Query("SELECT DISTINCT p FROM Projeto p LEFT JOIN FETCH p.funcionarios WHERE p.id = :id")
	    Optional<Projeto> findByIdWithFuncionarios(@Param("id") Long id);
	 
	 List<Projeto> findByDataInicioBetween(LocalDate dataInicio, LocalDate dataFim);
	 
	 @Query("SELECT DISTINCT p FROM Projeto p JOIN p.funcionarios f WHERE f.id = :funcionarioId")
	 List<Projeto> findByFuncionariosId(@Param("funcionarioId") Long funcionarioId);
	 
}
