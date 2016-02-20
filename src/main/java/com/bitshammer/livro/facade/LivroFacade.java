/**
 * 
 */
package com.bitshammer.livro.facade;

import javax.inject.Inject;

import com.bitshammer.livro.dao.ILivroDao;
import com.bitshammer.model.Livro;

/**
 * @author bruno.martins
 *
 */
class LivroFacade implements ILivroFacade {

	@Inject
	private ILivroDao dao;
	
	/**
	 * @see com.bitshammer.livro.facade.ILivroFacade#save(com.bitshammer.model.Livro)
	 */
	@Override
	public void save(Livro livro) {
		dao.persist(livro);

	}

}
