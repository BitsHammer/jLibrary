package com.bitshammer.test.autor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doAnswer;

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
		
		dao.persist(autor);
		assertEquals(1l, autor.getId().longValue());
	}
	
}
