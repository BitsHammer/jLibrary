/**
 * 
 */
package com.bitshammer.livro.facade;

import javax.inject.Inject;

import com.bitshammer.livro.Livro;
import com.bitshammer.livro.dao.ILivroDao;

/**
 * @author bruno.martins
 *
 */
class LivroFacade implements ILivroFacade {

	@Inject
	private ILivroDao dao;
	
	/**
	 * @see com.bitshammer.livro.facade.ILivroFacade#save(com.bitshammer.livro.Livro)
	 */
	@Override
	public void save(Livro livro) {
		dao.persist(livro);

	}

}
