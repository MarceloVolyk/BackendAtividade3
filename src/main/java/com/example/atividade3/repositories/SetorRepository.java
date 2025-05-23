package com.example.atividade3.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.atividade3.entities.Setor;

public interface SetorRepository extends JpaRepository<Setor, Long>{

	@Query("SELECT DISTINCT s FROM Setor s LEFT JOIN FETCH s.funcionarios")
    List<Setor> findAllWithFuncionarios();
	
	@Query("SELECT DISTINCT s FROM Setor s LEFT JOIN FETCH s.funcionarios WHERE s.id = :id")
	Optional<Setor> findByIdWithFuncionarios(@Param("id") Long id);
}
