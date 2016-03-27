/**
 * 
 */
package com.bitshammer.carrinho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bruno
 *
 */
public final class Carrinho implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1829333857410038071L;
	private List<Produto> produtos = new ArrayList<>();

	/**
	 * Adiciona um item na lista
	 * 
	 * @param item
	 *            Produto
	 */
	public void adicionarItem(Produto item) {
		produtos.add(item);
	}

	/**
	 * Remove um item na lista
	 * 
	 * @param item
	 *            Produto
	 */
	public void removerItem(Produto item) {
		produtos.remove(item);
	}

	/**
	 * Calcula o preco total
	 */
	public double precoTotal() {
		return produtos.stream().mapToDouble(Produto::valorTotal).sum();
	}

	/**
	 * retorna a quantidade de itens
	 */
	public int quantidadeItens() {
		return produtos.size();
	}
	
	/**
	 * Retorna os produtos selecionados
	 * @return
	 */
	public List<Produto> produtosSelecionados(){
		return produtos;
	}

}
