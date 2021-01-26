package com.algoworks.algamoneyapi.demo.model.dtos;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.algoworks.algamoneyapi.demo.model.dtos.comum.SelectedItemDTO;

public class PessoaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotNull
	@Size(max = 50)
	private String nome;
	
	@NotNull
	@Size(max = 14)
	private String cpf;
	
	@Embedded
	private EnderecoDTO endereco;
	
	@NotNull
	private SelectedItemDTO ativo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public SelectedItemDTO getAtivo() {
		return ativo;
	}

	public void setAtivo(SelectedItemDTO ativo) {
		this.ativo = ativo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
