/**
 * 
 */
package com.bitshammer.livro.facade;

import java.util.List;

import com.bitshammer.livro.Livro;
import com.bitshammer.livro.dao.ILivroDao;
import com.bitshammer.livro.dao.LivroDao;

/**
 * @author bruno.martins
 *
 */
public class LivroFacade implements ILivroFacade {

	
	private ILivroDao dao = new LivroDao();
	
	/**
	 * @see com.bitshammer.livro.facade.ILivroFacade#save(com.bitshammer.livro.Livro)
	 */
	@Override
	public void gravarLivro(Livro livro) {
		dao.persist(livro);
	}

	@Override
	public List<Livro> pesquisarCliente(Livro livro) {		
		return dao.pesquisarLivro(livro);
	}
	
}
