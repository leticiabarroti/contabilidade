package com.algoworks.algamoneyapi.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algoworks.algamoneyapi.demo.model.dtos.LancamentoDTO;
import com.algoworks.algamoneyapi.demo.service.LancamentoService;

@RestController
@RequestMapping("/lancamento")
public class LancamentoController {
	
	@Autowired
	private LancamentoService lancamentoService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LancamentoDTO> inserir (@Valid @RequestBody LancamentoDTO lancamentoDTO){
		return ResponseEntity.ok(lancamentoService.inserirOrAlterar(lancamentoDTO));
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LancamentoDTO> alterar (@Valid @RequestBody LancamentoDTO lancamentoDTO){
		return ResponseEntity.ok(lancamentoService.inserirOrAlterar(lancamentoDTO));
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LancamentoDTO>> recuperarTodos(){
		return ResponseEntity.ok(lancamentoService.recuperarTodos());
	}
	
	@GetMapping(value = ("/{id}"), produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LancamentoDTO> recuperarTodos(@PathVariable Long id){
		return ResponseEntity.ok(lancamentoService.recuperarLancamentoPorId(id));
	}
}
