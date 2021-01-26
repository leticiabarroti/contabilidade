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
import org.springframework.web.bind.annotation.RestController;

import com.algoworks.algamoneyapi.demo.model.dtos.CategoriaDTO;
import com.algoworks.algamoneyapi.demo.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoriaDTO> inserir(@Valid @RequestBody CategoriaDTO categoriaDTO) {
		return ResponseEntity.ok(categoriaService.inserirOrAlterar(categoriaDTO));
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoriaDTO> alterar (@Valid @RequestBody CategoriaDTO categoriaDTO){
		return ResponseEntity.ok(categoriaService.inserirOrAlterar(categoriaDTO));
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoriaDTO>> listar() {
		return ResponseEntity.ok(categoriaService.recuperarTodos());
	}
	
	@GetMapping(value = ("/id/{id}"), produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoriaDTO> listar(@PathVariable Long id) {
		return ResponseEntity.ok(categoriaService.recuperarCategoria(id));
	}

	@DeleteMapping(value = ("/{id}"), produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> remover (@PathVariable Long id){
		categoriaService.remover(id);
		return ResponseEntity.ok().build();
	}
}
