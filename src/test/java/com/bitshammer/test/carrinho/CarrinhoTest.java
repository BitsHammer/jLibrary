/**
 * 
 */
package com.bitshammer.test.carrinho;

import static org.junit.Assert.*;

import java.util.Arrays;

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
		Item item = new Item();
		item.setLivro(new Livro());
		item.setQuantidade(1);
		carrinho.adicionarItem(item);
		assertEquals(1, carrinho.quantidadeItens());
		System.out.println(carrinho);
	}
	
	@Test
	public void testRemover(){
		Carrinho carrinho = new Carrinho();
		assertEquals(0, carrinho.quantidadeItens());
		Item item = new Item();
		item.setLivro(new Livro());
		item.setQuantidade(1);
		carrinho.adicionarItem(item);
		assertEquals(1, carrinho.quantidadeItens());
		carrinho.removerItem(item);
		assertEquals(0, carrinho.quantidadeItens());
		System.out.println(carrinho);
	}
	
	@Test
	public void testSomar(){
		Carrinho carrinho = new Carrinho();
		Item item = new Item();
		Livro l = new Livro();
		l.setPrecoVenda(1d);
		item.setLivro(l);
		item.setQuantidade(1);
		carrinho.adicionarItem(item);
		assertEquals(1d, carrinho.precoTotal(),0d);
		carrinho.adicionarItem(item);
		assertEquals(2d, carrinho.precoTotal(),0d);
		Item p2 = new Item();
		Livro l2 = new Livro();
		l2.setPrecoVenda(1d);
		p2.setLivro(l2);
		p2.setQuantidade(5);
		carrinho.adicionarItem(p2);
		assertEquals(7d, carrinho.precoTotal(),0d);
		System.out.println(carrinho);
	}
	
	@Test
	public void testItensSelecionados(){
		Carrinho carrinho = new Carrinho();
		Item p = new Item();
		p.setLivro(new Livro());
		p.setQuantidade(1);
		carrinho.adicionarItem(p);
		Item p2 = new Item();
		p2.setLivro(new Livro());
		p2.setQuantidade(5);
		carrinho.adicionarItem(p2);
		assertTrue(carrinho.itensSelecionados().containsAll(Arrays.asList(p,p2)));
		System.out.println(carrinho);
	}

}
