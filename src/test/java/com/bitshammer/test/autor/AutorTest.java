package com.bitshammer.test.autor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doAnswer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.bitshammer.autor.Autor;
import com.bitshammer.autor.dao.IAutorDao;
import com.bitshammer.autor.facade.AutorFacade;
import com.bitshammer.autor.facade.IAutorFacade;

public class AutorTest {

	@Mock
	private IAutorDao dao;
	
	@InjectMocks
	private IAutorFacade facade = new AutorFacade();
	
	@Before
	public void before(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void salvarAutorSucesso(){
		final Autor autor = new Autor();
		autor.setNome("Teste");
		doAnswer(new Answer<Autor>() {

			@Override
			public Autor answer(InvocationOnMock invocation) throws Throwable {
				Autor autor = invocation.getArgumentAt(0, Autor.class);
				autor.setId(1);
				return autor;
			}
		}).when(dao).persist(autor);
		
		facade.save(autor);
		assertEquals(1l, autor.getId().longValue());
	}
	
	
	@Test
	public void buscarUmAutor(){
		final Autor autor = new Autor();
		autor.setNome("Teste");
		doAnswer(new Answer<List<Autor>>() {

			@Override
			public List<Autor> answer(InvocationOnMock invocation)
					throws Throwable {
				Autor a = new Autor();
				a.setNome("A");
				Autor b = new Autor();
				b.setNome("B");
				return Arrays.asList(a,b);
			}

			
		}).when(dao).findByParams(autor);
		
		List<Autor> list = facade.findByParams(autor);
		assertEquals(2, list.size());
	}
	
	@Test
	public void buscarAutorInexistente(){
		final Autor autor = new Autor();
		autor.setNome("Teste");
		doAnswer(new Answer<List<Autor>>() {

			@Override
			public List<Autor> answer(InvocationOnMock invocation)
					throws Throwable {
				return new ArrayList<Autor>();
			}

			
		}).when(dao).findByParams(autor);
		
		List<Autor> list = facade.findByParams(autor);
		assertEquals(0, list.size());
	}
	
	@Test
	public void buscarTodosAutores(){
		doAnswer(new Answer<List<Autor>>() {

			@Override
			public List<Autor> answer(InvocationOnMock invocation)
					throws Throwable {
				Autor a = new Autor();
				a.setNome("A");
				Autor b = new Autor();
				b.setNome("B");
				return Arrays.asList(a,b);
			}

			
		}).when(dao).listAll();
		
		List<Autor> list = facade.listAll();
		assertEquals(2, list.size());
	}
	
	
}
