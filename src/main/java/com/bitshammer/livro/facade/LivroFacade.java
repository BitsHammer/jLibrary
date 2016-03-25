/**
 * 
 */
package com.bitshammer.livro.facade;

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
	public void save(Livro livro) {
		dao.persist(livro);

	}

}
