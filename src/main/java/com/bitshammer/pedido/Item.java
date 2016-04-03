package com.bitshammer.pedido;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.bitshammer.livro.Livro;

/**
 * Classe contendo um item de venda ou pedido
 * 
 * @author Bruno
 */
public class Item implements Serializable {
	
	@Id
	@Column(name="item_id")
	@GeneratedValue
	private Integer id;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3302325467661797883L;

	/**
	 * Items do pedido
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="livro_id", referencedColumnName="livro_id")
	private Livro livro;

	/**
	 * Quantidade de itens do produto
	 */
	@Column
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
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		return id.equals(((Item)obj).getId());
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param livro the livro to set
	 */
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	

}
