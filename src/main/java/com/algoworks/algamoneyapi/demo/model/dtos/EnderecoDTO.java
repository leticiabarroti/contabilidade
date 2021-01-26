package com.algoworks.algamoneyapi.demo.model.dtos;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.algoworks.algamoneyapi.demo.model.dtos.comum.SelectedItemDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EnderecoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(max = 50)
	private String logradouro;
	
	@NotNull
	@Size(max = 5)
	private String numero;
	
	@Size(max = 50)
	private String complemento;
	
	@NotNull
	@Size(max = 100)
	private String bairro;
	
	@NotNull
	@Size(max = 10)
	private String cep;
		
	@NotNull
	@Size(max = 20)
	private String cidade;
	
	@NotNull
	private SelectedItemDTO estado;
}
