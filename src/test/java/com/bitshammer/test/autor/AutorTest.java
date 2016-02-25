package com.bitshammer.test.autor;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.bitshammer.autor.dao.IAutorDao;
import com.bitshammer.autor.facade.IAutorFacade;
import com.bitshammer.model.Autor;
import com.bitshammer.test.WeldJUnit4Runner;

@RunWith(WeldJUnit4Runner.class)
public class AutorTest {

	@Mock
	private IAutorDao dao;
	
	@Inject
	@InjectMocks
	private IAutorFacade facade;
	
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
				autor.setId(1l);
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
