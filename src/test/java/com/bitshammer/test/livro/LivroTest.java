/**
 * 
 */
package com.bitshammer.test.livro;

import java.util.Arrays;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.bitshammer.livro.facade.ILivroFacade;
import com.bitshammer.model.Autor;
import com.bitshammer.model.Editora;
import com.bitshammer.model.Livro;
import com.bitshammer.test.WeldJUnit4Runner;

/**
 * @author bruno.martins
 *
 */
@RunWith(WeldJUnit4Runner.class)
public class LivroTest {
	
	@Inject
	private ILivroFacade facade;	
	
	@Test
	public void salvarLivro(){
		Livro livro = new Livro();
		livro.setQtdPaginas(999);
		livro.setNome("TESTE");
		livro.setEditora(new Editora("Editora"));
		livro.setAutores(Arrays.asList(new Autor("Autor")));
		
	}

}
