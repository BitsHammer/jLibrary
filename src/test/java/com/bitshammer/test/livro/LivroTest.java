/**
 * 
 */
package com.bitshammer.test.livro;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doAnswer;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.bitshammer.autor.Autor;
import com.bitshammer.editora.Editora;
import com.bitshammer.livro.Livro;
import com.bitshammer.livro.dao.ILivroDao;
import com.bitshammer.livro.facade.ILivroFacade;
import com.bitshammer.livro.facade.LivroFacade;

/**
 * @author bruno.martins
 *
 */
public class LivroTest {
	
	@InjectMocks
	private ILivroFacade facade = new LivroFacade();
	
	@Mock
	private ILivroDao dao;
	
	@Before
	public void before(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void salvarLivro(){
		Livro livro = new Livro();
		livro.setNumeroPaginas(999);
		livro.setTitulo("TESTE");
		livro.setEditora(new Editora("Editora"));
		livro.setAutores(Arrays.asList(new Autor("Autor")));
		doAnswer(new Answer<Livro>() {

			@Override
			public Livro answer(InvocationOnMock invocation) throws Throwable {
				Livro livro = invocation.getArgumentAt(0, Livro.class);
				livro.setId(1);
				return livro;
			}
		}).when(dao).persist(livro);
		
		facade.gravarLivro(livro);
		assertEquals(1l, livro.getId().longValue());
		
	}

}
