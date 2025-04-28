package com.example.atividade3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.atividade3.dtos.SetorDTO;
import com.example.atividade3.services.SetorService;

@RestController
@RequestMapping("/setores")
public class SetorController {

	@Autowired
	private SetorService service;
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionar(@RequestBody SetorDTO setorDTO) {
        service.salvarSetor(setorDTO);
    }
}
