package com.example.atividade3.exceptions;

public class FuncionarioNotFoundException extends RuntimeException{

	public FuncionarioNotFoundException(String mensagem) {
		super(mensagem);
	}
}
