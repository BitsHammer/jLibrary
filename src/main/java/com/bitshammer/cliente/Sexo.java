/**
 * 
 */
package com.bitshammer.cliente;

/**
 * Enumera��o de sexo 	
 * @author Bruno
 *
 */
public enum Sexo {
	
	M("Homem"),
	F("Mulher");
	
	/**
	 * Sexo
	 */
	private String sexo;

	/**
	 * Construtor
	 * @param sexo
	 */
	private Sexo(String sexo) {
		this.sexo = sexo;
	}

}
