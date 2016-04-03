/**
 * 
 */
package com.bitshammer.cliente;

/**
 * Enumeração de sexo 	
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
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return sexo;
	}

}
