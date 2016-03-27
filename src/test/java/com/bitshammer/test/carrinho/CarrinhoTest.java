/**
 * 
 */
package com.bitshammer.test.carrinho;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import com.bitshammer.carrinho.Carrinho;
import com.bitshammer.carrinho.Produto;
import com.bitshammer.livro.Livro;

/**
 * @author Bruno
 *
 */
public class CarrinhoTest {
	
	@Test
	public void testAdicionar(){
		Carrinho carrinho = new Carrinho();
		assertEquals(0, carrinho.quantidadeItens());
		carrinho.adicionarItem(new Produto(new Livro()));
		assertEquals(1, carrinho.quantidadeItens());
	}
	
	@Test
	public void testRemover(){
		Carrinho carrinho = new Carrinho();
		assertEquals(0, carrinho.quantidadeItens());
		Produto p = new Produto(new Livro());
		carrinho.adicionarItem(p);
		assertEquals(1, carrinho.quantidadeItens());
		carrinho.removerItem(p);
		assertEquals(0, carrinho.quantidadeItens());
	}
	
	@Test
	public void testSomar(){
		Carrinho carrinho = new Carrinho();
		Produto p = new Produto(new Livro());
		carrinho.adicionarItem(p);
		assertEquals(1d, carrinho.precoTotal(),0d);
		carrinho.adicionarItem(p);
		assertEquals(2d, carrinho.precoTotal(),0d);
		Produto p2 = new Produto(new Livro());
		p2.setQuantidade(5);
		carrinho.adicionarItem(p2);
		assertEquals(7d, carrinho.precoTotal(),0d);
	}

}
