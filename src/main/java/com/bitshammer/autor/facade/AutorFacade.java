/**
 * 
 */
package com.bitshammer.autor.facade;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;

import com.bitshammer.autor.dao.IAutorDao;
import com.bitshammer.model.Autor;

/**
 * @author Bruno
 *
 */
class AutorFacade implements IAutorFacade {

	@Inject
	private IAutorDao dao;
	
	@Inject
	private Logger log;
	
	/**
	 * @see com.bitshammer.autor.facade.IAutorFacade#save(com.bitshammer.model.Autor)
	 */
	@Override
	public void save(Autor autor) {
		log.log(Level.INFO, "Entrou");
		dao.persist(autor);
		log.log(Level.INFO, "saiu");
	}

}
