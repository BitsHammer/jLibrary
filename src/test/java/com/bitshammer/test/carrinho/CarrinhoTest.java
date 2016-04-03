/**
 * 
 */
package com.bitshammer.test.carrinho;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bitshammer.carrinho.Carrinho;
import com.bitshammer.livro.Livro;
import com.bitshammer.pedido.Item;

/**
 * @author Bruno
 *
 */
public class CarrinhoTest {	
	
	@Test
	public void testAdicionar(){
		Carrinho carrinho = new Carrinho();
		assertEquals(0, carrinho.quantidadeItens());
		carrinho.adicionarItem(new Item(new Livro()));
		assertEquals(1, carrinho.quantidadeItens());
	}
	
	@Test
	public void testRemover(){
		Carrinho carrinho = new Carrinho();
		assertEquals(0, carrinho.quantidadeItens());
		Item p = new Item(new Livro());
		carrinho.adicionarItem(p);
		assertEquals(1, carrinho.quantidadeItens());
		carrinho.removerItem(p);
		assertEquals(0, carrinho.quantidadeItens());
	}
	
	@Test
	public void testSomar(){
		Carrinho carrinho = new Carrinho();
		Item p = new Item(new Livro());
		carrinho.adicionarItem(p);
		assertEquals(1d, carrinho.precoTotal(),0d);
		carrinho.adicionarItem(p);
		assertEquals(2d, carrinho.precoTotal(),0d);
		Item p2 = new Item(new Livro());
		p2.setQuantidade(5);
		carrinho.adicionarItem(p2);
		assertEquals(7d, carrinho.precoTotal(),0d);
	}

}
