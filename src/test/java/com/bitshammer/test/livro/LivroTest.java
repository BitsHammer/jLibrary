/**
 * 
 */
package com.bitshammer.test.livro;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.bitshammer.autor.AutorMock;
import com.bitshammer.editora.EditoraMock;
import com.bitshammer.livro.Categoria;
import com.bitshammer.livro.FormatoLivro;
import com.bitshammer.livro.Livro;
import com.bitshammer.livro.facade.ILivroFacade;
import com.bitshammer.livro.facade.LivroFacade;

/**
 * @author leticia.costa
 *
 */
public class LivroTest {
	
	private ILivroFacade facade = new LivroFacade();
	
	private static Livro livro;
	
	@BeforeClass
	public static void tearUp(){
		livro = new Livro();
		livro.setNumeroPaginas(999);
		livro.setTitulo("TESTE");
		livro.setEditora(EditoraMock.getInstance().listaEditora.get(0));
		livro.setAutores(AutorMock.getInstance().listaAutor);
		livro.setCategorias(Arrays.asList(Categoria.values()));
		livro.setNumeroPaginas(999);
		livro.setPrecoCusto(99d);
		livro.setPrecoVenda(299d);
		livro.setDataPublicacao(new Date());
		livro.setIndice("Indice");
		livro.setResumo("Resumo");
		livro.setIsbn(99l);
		livro.setQuantidadeEstoque(24);
		livro.setFormato(FormatoLivro.BROCHURA);
	}
	
	@Test
	public void salvarLivro(){
		facade.gravarLivro(livro);
		assertNotNull(livro.getId());
		System.out.println(livro);
	}
	
	@Test
	public void testaLivroIgual(){
		Livro livro = new Livro();
		livro.setId(1);
		Livro livro2 = new Livro();
		livro2.setId(1);
		assertEquals(livro,livro2);
		livro2.setId(2);
		assertNotEquals(livro,livro2);
		assertNotEquals(livro,null);
		
	}
	
	@Test
	public void testaEnumsDeLivro(){
		Integer id = Categoria.PAIXAO.getId();
		String nome = Categoria.PAIXAO.getNome();
		assertEquals(Integer.valueOf(2), id);
		assertEquals("Paixao", nome);
		
		id = FormatoLivro.BROCHURA.getId();
		FormatoLivro formato = FormatoLivro.byId(id);
		System.out.println(formato);
		assertEquals(formato, FormatoLivro.BROCHURA);
	}
	
	@Test
	public void atualizarLivro(){
		Livro livro = new Livro();
		livro.setNumeroPaginas(999);
		livro.setTitulo("TESTE");
		livro.setEditora(EditoraMock.getInstance().listaEditora.get(0));
		livro.setAutores(AutorMock.getInstance().listaAutor);
		livro.setCategorias(Arrays.asList(Categoria.values()));
		livro.setNumeroPaginas(999);
		livro.setPrecoCusto(99d);
		livro.setPrecoVenda(299d);
		livro.setDataPublicacao(new Date());
		livro.setIndice("Indice");
		livro.setResumo("Resumo");
		livro.setIsbn(99l);
		livro.setQuantidadeEstoque(24);
		livro.setFormato(FormatoLivro.BROCHURA);
		facade.gravarLivro(livro);
		livro.setTitulo("Novo titulo");
		facade.atualizarLivro(livro);
	}

}
