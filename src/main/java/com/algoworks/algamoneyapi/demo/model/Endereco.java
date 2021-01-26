package com.algoworks.algamoneyapi.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;

import com.algoworks.algamoneyapi.demo.model.enuns.EstadoEnum;
import com.algoworks.algamoneyapi.demo.model.enuns.EstadoEnumConverter;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Setter
@Getter
@EqualsAndHashCode
public class Endereco implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "DS_LOGRADOURO")
	private String logradouro;
	
	@Column(name = "NU_ENDERECO")
	private String numero;
	
	@Column(name = "DS_COMPLEMENTO")
	private String complemento;
	
	@Column(name = "DS_BAIRRO")
	private String bairro;
	
	@Column(name = "NU_CEP")
	private String cep;
		
	@Column(name = "DS_CIDADE")
	private String cidade;
	
	@Convert(converter = EstadoEnumConverter.class)
	@Column(name = "DS_ESTADO")
	private EstadoEnum estado;
}
