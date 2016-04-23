/**
 * 
 */
package com.bitshammer.livro;

/**
 * @author Bruno
 *
 */
public enum Categoria {
	
	TERROR(1,"Terror"),
	PAIXAO(2,"Paixao");
	
	private String nome;
	
	private Integer id;
	

	public String getNome() {
		return nome;
	}

	private Categoria(Integer id, String nome) {
		this.id =id;
		this.nome = nome;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

}
