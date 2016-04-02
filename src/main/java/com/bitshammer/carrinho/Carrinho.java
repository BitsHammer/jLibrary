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
	private List<Item> itens = new ArrayList<>();

	/**
	 * Adiciona um item na lista
	 * 
	 * @param item
	 *            Produto
	 */
	public void adicionarItem(Item item) {
		itens.add(item);
	}

	/**
	 * Remove um item na lista
	 * 
	 * @param item
	 *            Produto
	 */
	public void removerItem(Item item) {
		itens.remove(item);
	}

	/**
	 * Calcula o preco total
	 */
	public double precoTotal() {
		return itens.stream().mapToDouble(Item::valorTotal).sum();
	}

	/**
	 * retorna a quantidade de itens
	 */
	public int quantidadeItens() {
		return itens.size();
	}
	
	/**
	 * Retorna os itens selecionados
	 * @return
	 */
	public List<Item> itensSelecionados(){
		return itens;
	}

}
