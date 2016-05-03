/**
 * 
 */
package com.bitshammer.carrinho.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.bitshammer.carrinho.Carrinho;
import com.bitshammer.infra.bean.DefaultBean;
import com.bitshammer.livro.Livro;
import com.bitshammer.pedido.Item;

/**
 * @author Bruno
 *
 */
@ManagedBean
@SessionScoped
public class CarrinhoBean extends DefaultBean {

	private Carrinho carrinho;
	
	/**
	 * Construtor
	 */
	public CarrinhoBean() {
		carrinho = new Carrinho();
	}

	/**
	 * @return the carrinho
	 */
	public Carrinho getCarrinho() {
		return carrinho;
	}

	/**
	 * @param carrinho the carrinho to set
	 */
	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}
	
	public void adicionarItem(Livro livro, Integer quantidade){
		Item item=new Item();
		item.setLivro(livro);
		item.setQuantidade(quantidade);
		carrinho.adicionarItem(item);
		addMessage("Sucesso", "Item adiconado!");
	}

}
