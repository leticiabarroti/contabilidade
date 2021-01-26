package com.algoworks.algamoneyapi.demo.model.dtos;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.algoworks.algamoneyapi.demo.model.dtos.comum.SelectedItemDTO;

import lombok.Data;

@Data
public class LancamentoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotNull
	@Size(max = 50)
	private String descricao;

	private Date dataPagamento;

	@NotNull
	private Date dataVencimento;

	@NotNull
	private Double valor;

	@Size(max = 50)
	private String observacao;

	@NotNull
	private SelectedItemDTO tipo;
	
	private PessoaDTO pessoa;

	private CategoriaDTO categoria;
}
