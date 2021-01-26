package com.algoworks.algamoneyapi.demo.model.enuns;

import javax.persistence.AttributeConverter;

public class EstadoEnumConverter  implements AttributeConverter<EstadoEnum, String>{
	
	@Override
	public String convertToDatabaseColumn(EstadoEnum attribute) {
		return attribute.getCodigo();
	}

	@Override
	public EstadoEnum convertToEntityAttribute(String dbData) {
		return EstadoEnum.recuperarEnum(dbData);
	}

}
