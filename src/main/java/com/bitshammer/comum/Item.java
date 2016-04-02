package com.bitshammer.comum;

import java.io.Serializable;

import com.bitshammer.livro.Livro;

/**
 * Classe contendo um produto
 * 
 * @author Bruno
 */
public class Item implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3302325467661797883L;

	/**
	 * Produto
	 */
	private Livro livro;

	/**
	 * Quantidade de itens do produto
	 */
	private int quantidade;

	/**
	 * Construtor
	 * @param livro livro
	 * @param quantidade quantidade
	 */
	public Item(Livro livro) {
		this.livro = livro;
		this.quantidade = 1;
	}

	/**
	 * @return the livro
	 */
	public Livro getLivro() {
		return livro;
	}

	/**
	 * @return the quantidade
	 */
	public int getQuantidade() {
		return quantidade;
	}
	
	/**
	 * Retorna o valor total
	 */
	public double valorTotal(){
		return 1d * quantidade;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Produto [livro=");
		builder.append(livro);
		builder.append(", quantidade=");
		builder.append(quantidade);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	

}
