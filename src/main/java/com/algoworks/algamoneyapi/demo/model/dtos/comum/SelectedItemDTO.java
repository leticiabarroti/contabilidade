package com.algoworks.algamoneyapi.demo.model.dtos.comum;

import java.io.Serializable;

public class SelectedItemDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4421904411765331144L;

	private String value;
	private String label;

	public SelectedItemDTO() {
	}

	public SelectedItemDTO(String value, String label) {
		this.value = value;
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
