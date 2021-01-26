package com.algoworks.algamoneyapi.demo.exceptions;

public class NegocioException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -719054227141139558L;
	
	public NegocioException(String mensagem) {
		super(mensagem);
	}

}
