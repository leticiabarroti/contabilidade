package com.algoworks.algamoneyapi.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.algoworks.algamoneyapi.demo.model.dtos.PessoaDTO;
import com.algoworks.algamoneyapi.demo.service.PessoaService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PessoaDTO> incluir (@Valid @RequestBody PessoaDTO pessoaDTO){
		return ResponseEntity.ok(pessoaService.incluir(pessoaDTO));
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PessoaDTO> alterar (@Valid @RequestBody PessoaDTO pessoaDTO){
		return ResponseEntity.ok(pessoaService.alterar(pessoaDTO));
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PessoaDTO>> recuperarTodos (){
		return ResponseEntity.ok(pessoaService.recuperarTodos());
	}
	
	@GetMapping(value = ("id/{id}"), produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PessoaDTO> recuperarPorCpf (@PathVariable Long id){
		return ResponseEntity.ok(pessoaService.recuperarPorId(id));
	}
	
	@DeleteMapping(value = ("/{id}"), produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> remover (@PathVariable Long id){
		pessoaService.remover(id);
		return ResponseEntity.ok().build();
	}

}
