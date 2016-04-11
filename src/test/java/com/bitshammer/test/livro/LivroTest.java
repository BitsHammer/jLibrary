/**
 * 
 */
package com.bitshammer.test.livro;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doAnswer;

import java.util.Arrays;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.bitshammer.autor.Autor;
import com.bitshammer.autor.AutorMock;
import com.bitshammer.editora.Editora;
import com.bitshammer.editora.EditoraMock;
import com.bitshammer.livro.Categoria;
import com.bitshammer.livro.Livro;
import com.bitshammer.livro.dao.ILivroDao;
import com.bitshammer.livro.facade.ILivroFacade;
import com.bitshammer.livro.facade.LivroFacade;

/**
 * @author bruno.martins
 *
 */
public class LivroTest {
	
	private ILivroFacade facade = new LivroFacade();
	
	
	@Test
	public void salvarLivro(){
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
		facade.gravarLivro(livro);
		assertEquals(1l, livro.getId().longValue());
		
	}

}
