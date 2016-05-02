package com.bitshammer.test.autor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.bitshammer.autor.Autor;
import com.bitshammer.autor.facade.AutorFacade;
import com.bitshammer.autor.facade.IAutorFacade;

public class AutorTest {

	
	private IAutorFacade facade = new AutorFacade();
	
	@Test
	public void salvarAutorSucesso(){
		final Autor autor = new Autor();
		autor.setBiografia("Biografia");
		autor.setDtFalecimento(new Date());
		autor.setDtNascimento(new Date());
		autor.setLocalMorte("Aqui");
		autor.setLocalNascimento("lá");
		autor.setNome("Teste");
		facade.save(autor);
		assertTrue(autor.getId() != null);
	}
	
	
	@Test
	public void buscarUmAutor(){
		Autor autor = new Autor();
		autor.setBiografia("Biografia");
		autor.setDtFalecimento(new Date());
		autor.setDtNascimento(new Date());
		autor.setLocalMorte("Aqui");
		autor.setLocalNascimento("lá");
		autor.setNome("Teste3");
		facade.save(autor);
		autor = null;
		autor = new Autor("Teste3");
		List<Autor> list = facade.findByParams(autor);
		assertEquals(1, list.size());
	}
	
	@Test
	public void buscarAutorInexistente(){
		final Autor autor = new Autor();
		autor.setNome("TesteBlabla");
		List<Autor> list = facade.findByParams(autor);
		assertEquals(0, list.size());
	}
	
	@Test
	public void buscarTodosAutores(){
		Autor autor = new Autor();
		autor.setBiografia("Biografia");
		autor.setDtFalecimento(new Date());
		autor.setDtNascimento(new Date());
		autor.setLocalMorte("Aqui");
		autor.setLocalNascimento("lá");
		autor.setNome("Teste");
		facade.save(autor);
		autor = new Autor();
		autor.setBiografia("Biografia2");
		autor.setDtFalecimento(new Date());
		autor.setDtNascimento(new Date());
		autor.setLocalMorte("Aqui2");
		autor.setLocalNascimento("lá2");
		autor.setNome("Teste2");
		facade.save(autor);
		List<Autor> list = facade.listAll();
		assertTrue(list.size() >= 2);
	}
	
	
	
}
