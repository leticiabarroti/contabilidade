package com.algoworks.algamoneyapi.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.algoworks.algamoneyapi.demo.model.enuns.AtivoEnum;
import com.algoworks.algamoneyapi.demo.model.enuns.AtivoEnumConverter;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TB_PESSOA")
@Setter
@Getter
@EqualsAndHashCode
public class Pessoa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NO_PESSOA")
	private String nome;
	
	@Column(name = "NU_CPF")
	private String cpf;
	
	@Embedded
	private Endereco endereco;
	
	@Convert(converter = AtivoEnumConverter.class)
	@Column(name = "IC_ATIVO")
	private AtivoEnum ativo;
}
