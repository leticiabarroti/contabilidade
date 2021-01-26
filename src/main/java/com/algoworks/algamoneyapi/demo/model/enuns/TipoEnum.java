package com.algoworks.algamoneyapi.demo.model.enuns;

public enum TipoEnum {
	RECEITA("RE", "Receita"),
	DESPESA("DE", "Despesa");
	
	private String codigo;
	private String descricao;
	
	private TipoEnum(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public static TipoEnum recuperarEnum(String codigo) {
		TipoEnum enumAux = null;
		
		for (TipoEnum itemLista : TipoEnum.values()) {
			if(itemLista.getCodigo().equals(codigo)) {
				enumAux = itemLista;
				break;
			}
		}
		return enumAux;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
