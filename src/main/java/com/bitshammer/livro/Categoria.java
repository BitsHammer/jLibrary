/**
 * 
 */
package com.bitshammer.livro;

/**
 * @author Bruno
 *
 */
public enum Categoria {
	
	TERROR("Terror"),
	PAIXAO("Paixao");
	
	private String nome;

	public String getNome() {
		return nome;
	}

	private Categoria(String nome) {
		this.nome = nome;
	}

}
