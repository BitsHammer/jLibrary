/**
 * 
 */
package com.bitshammer.carrinho.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.bitshammer.carrinho.Carrinho;
import com.bitshammer.infra.bean.DefaultBean;
import com.bitshammer.livro.Livro;
import com.bitshammer.pedido.Item;

/**
 * @author Bruno
 *
 */
@ManagedBean
@ViewScoped
public class CarrinhoBean extends DefaultBean {

	private Carrinho carrinho;
	
	/**
	 * Construtor
	 */
	public CarrinhoBean() {
		carrinho = new Carrinho();
		Livro livro = new Livro();
		livro.setTitulo("Teste");
		Livro livro2 = new Livro();
		livro2.setTitulo("Blabla");
		
		Item item = new Item();
		item.setLivro(livro);
		
		Item item2 = new Item();
		item.setLivro(livro2);
				
		carrinho.adicionarItem(item);
		carrinho.adicionarItem(item2);
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
	
	public String adicionarItem(Livro livro){
		carrinho = new Carrinho();
		Item item=new Item();
		item.setLivro(livro);
		
		carrinho.adicionarItem(item);
		
		
		return "carrinho";
	}

}
