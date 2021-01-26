package com.algoworks.algamoneyapi.demo.model.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CategoriaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotNull
	@Size(max = 50)
	private String nome;
}
