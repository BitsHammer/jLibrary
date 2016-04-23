/**
 * 
 */
package com.bitshammer.test.livro;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.Date;

import org.junit.Test;

import com.bitshammer.autor.AutorMock;
import com.bitshammer.editora.EditoraMock;
import com.bitshammer.livro.Categoria;
import com.bitshammer.livro.Livro;
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
		assertNotNull(livro.getId());
		
	}

}
