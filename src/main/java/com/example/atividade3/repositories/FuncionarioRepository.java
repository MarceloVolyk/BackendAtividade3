package com.example.atividade3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.atividade3.entities.Funcionario;
import com.example.atividade3.entities.Projeto;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

	@Query("SELECT p FROM Projeto p JOIN p.funcionarios f WHERE f.id = :funcionarioId")
    List<Projeto> findProjetosByFuncionarioId(@Param("funcionarioId") Long funcionarioId);
}
