package com.algoworks.algamoneyapi.demo.model.enuns;

import javax.persistence.AttributeConverter;

import org.springframework.stereotype.Component;

@Component
public class AtivoEnumConverter implements AttributeConverter<AtivoEnum, String>{

	@Override
	public String convertToDatabaseColumn(AtivoEnum attribute) {
		return attribute.getCodigo();
	}

	@Override
	public AtivoEnum convertToEntityAttribute(String dbData) {
		return AtivoEnum.recuperarEnum(dbData);
	}

}
