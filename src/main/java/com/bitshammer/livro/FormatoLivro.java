/**
 * 
 */
package com.bitshammer.livro;

/**
 * @author Bruno
 *
 */
public enum FormatoLivro {
	
	CAPADURA("Capa dura"),
	BROCHURA("Brochura");
	
	/**
	 * Formato
	 */
	private String formato;

	/**
	 * Construtor
	 * @param formato
	 */
	private FormatoLivro(String formato) {
		this.formato = formato;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return formato;
	}
	
	

}
