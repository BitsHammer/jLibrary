/**
 * 
 */
package com.bitshammer.carrinho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.bitshammer.comum.Item;

/**
 * @author Bruno
 *
 */
public final class Carrinho implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1829333857410038071L;
	private List<Item> produtos = new ArrayList<>();

	/**
	 * Adiciona um item na lista
	 * 
	 * @param item
	 *            Produto
	 */
	public void adicionarItem(Item item) {
		produtos.add(item);
	}

	/**
	 * Remove um item na lista
	 * 
	 * @param item
	 *            Produto
	 */
	public void removerItem(Item item) {
		produtos.remove(item);
	}

	/**
	 * Calcula o preco total
	 */
	public double precoTotal() {
		return produtos.stream().mapToDouble(Item::valorTotal).sum();
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
	public List<Item> produtosSelecionados(){
		return produtos;
	}

}
