/**
 * 
 */
package com.bitshammer.carrinho.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.bitshammer.carrinho.Carrinho;
import com.bitshammer.carrinho.Produto;
import com.bitshammer.infra.bean.DefaultBean;
import com.bitshammer.livro.Livro;

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
		livro.setNome("Teste");
		Livro livro2 = new Livro();
		livro2.setNome("Blabla");
		carrinho.adicionarItem(new Produto(livro));
		carrinho.adicionarItem(new Produto(livro2));
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

}
