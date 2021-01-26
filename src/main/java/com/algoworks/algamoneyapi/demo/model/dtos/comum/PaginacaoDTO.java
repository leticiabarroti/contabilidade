package com.algoworks.algamoneyapi.demo.model.dtos.comum;

import java.io.Serializable;

public class PaginacaoDTO<F> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4308333188486340596L;
	
	private F filtro;
	private Integer quantidadePorPagina;
	private Integer numeroPagina;
	
	public F getFiltro() {
		return filtro;
	}
	public void setFiltro(F filtro) {
		this.filtro = filtro;
	}
	public Integer getQuantidadePorPagina() {
		return quantidadePorPagina;
	}
	public void setQuantidadePorPagina(Integer quantidadePorPagina) {
		this.quantidadePorPagina = quantidadePorPagina;
	}
	public Integer getNumeroPagina() {
		return numeroPagina;
	}
	public void setNumeroPagina(Integer numeroPagina) {
		this.numeroPagina = numeroPagina;
	}
}
