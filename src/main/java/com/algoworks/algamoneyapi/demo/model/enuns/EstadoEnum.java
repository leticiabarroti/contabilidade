package com.algoworks.algamoneyapi.demo.model.enuns;

public enum EstadoEnum {
	    AC("AC", "Acre"),
	    AL("AL", "Alagoas"),
	    AP("AP", "Amapá"),
	    AM("AM", "Amazonas"),
	    BA("BA", "Bahia"),
	    CE("CE", "Ceará"),
	    DF("DF", "Distrito Federal"),
	    ES("ES", "Espírito Santo"),
	    GO("GO", "Goiás"),
	    MA("MA", "Maranhão"),
	    MT("MT", "Mato Grosso"),
	    MS("MS", "Mato Grosso do Sul"),
	    MG("MG", "Minas Gerais"),
	    PA("PA", "Pará"),
	    PB("PB", "Paraíba"),
	    PR("PR", "Paraná"),
	    PE("PE", "Pernambuco"),
	    PI("PI", "Piauí"),
	    RJ("RJ", "Rio de Janeiro"),
	    RN("RN", "Rio Grande do Norte"),
	    RS("RS", "Rio Grande do Sul"),
	    RO("RO", "Rondônia"),
	    RR("RR", "Roraima"),
	    SC("SC", "Santa Catarina"),
	    SP("SP", "São Paulo"),
	    SE("SE", "Sergipe"),
	    TO("TO", "Tocantins");
	    
		private String codigo;
		private String descricao;
			
		private EstadoEnum(String codigo, String descricao) {
			this.codigo = codigo;
			this.descricao = descricao;
		}
		
		public static EstadoEnum recuperarEnum(String codigo) {
			EstadoEnum enumAux = null;
			
			for (EstadoEnum itemLista : EstadoEnum.values()) {
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
