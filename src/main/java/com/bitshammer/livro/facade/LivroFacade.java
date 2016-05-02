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
	
	/*
	 * (non-Javadoc)
	 * @see com.bitshammer.livro.facade.ILivroFacade#gravarLivro(com.bitshammer.livro.Livro)
	 */
	@Override
	public void gravarLivro(Livro livro) {
		dao.persist(livro);
	}

	/*
	 * (non-Javadoc)
	 * @see com.bitshammer.livro.facade.ILivroFacade#pesquisarCliente(com.bitshammer.livro.Livro)
	 */
	@Override
	public List<Livro> pesquisarLivro(Livro livro) {		
		return dao.pesquisarLivro(livro);
	}

	/*
	 * (non-Javadoc)
	 * @see com.bitshammer.livro.facade.ILivroFacade#atualizarLivro(com.bitshammer.livro.Livro)
	 */
	@Override
	public void atualizarLivro(Livro livro) {
		dao.update(livro);
	}

	/*
	 * (non-Javadoc)
	 * @see com.bitshammer.livro.facade.ILivroFacade#excluirLivro(com.bitshammer.livro.Livro)
	 */
	@Override
	public void excluirLivro(Livro livro) {
		dao.remove(livro);
		
	}
	
}
