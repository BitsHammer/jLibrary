/**
 * 
 */
package com.bitshammer.autor.facade;

import javax.inject.Inject;

import com.bitshammer.autor.IAutorDao;
import com.bitshammer.autor.IAutorFacade;
import com.bitshammer.model.Autor;

/**
 * @author Bruno
 *
 */
class AutorFacade implements IAutorFacade {

	@Inject
	private IAutorDao dao;
	
	/**
	 * @see com.bitshammer.autor.IAutorFacade#save(com.bitshammer.model.Autor)
	 */
	@Override
	public void save(Autor autor) {
		dao.persist(autor);
	}

}
