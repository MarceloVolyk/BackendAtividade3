package com.example.atividade3.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "departamento_id")
	private Setor setor;
	
	@ManyToMany
	@JoinTable(
	    name = "funcionario_projeto",
	    joinColumns = @JoinColumn(name = "funcionario_id"),
	    inverseJoinColumns = @JoinColumn(name = "projeto_id")
	)
	private Set<Projeto> projetos = new HashSet<>();
}
