package com.algoworks.algamoneyapi.demo.exceptions;

public class NotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2494278903800617112L;

	public NotFoundException(String mensagem) {
		super(mensagem);
	}
}
