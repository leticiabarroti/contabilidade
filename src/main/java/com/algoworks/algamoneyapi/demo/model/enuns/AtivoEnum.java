package com.algoworks.algamoneyapi.demo.model.enuns;

public enum AtivoEnum {
	SIM("S", "Sim"),
	NAO("N", "Não");
	
	private String codigo;
	private String descricao;
		
	private AtivoEnum(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public static AtivoEnum recuperarEnum(String codigo) {
		AtivoEnum enumAux = null;
		
		for (AtivoEnum itemLista : AtivoEnum.values()) {
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
