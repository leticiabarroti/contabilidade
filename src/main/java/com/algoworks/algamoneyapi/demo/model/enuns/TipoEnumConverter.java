package com.algoworks.algamoneyapi.demo.model.enuns;

import javax.persistence.AttributeConverter;

public class TipoEnumConverter implements AttributeConverter<TipoEnum, String>{

	@Override
	public String convertToDatabaseColumn(TipoEnum attribute) {
		return attribute.getCodigo();
	}

	@Override
	public TipoEnum convertToEntityAttribute(String dbData) {
		return TipoEnum.recuperarEnum(dbData);
	}

}
