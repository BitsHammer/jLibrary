/**
 * 
 */
package com.bitshammer.autor.facade;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;

import com.bitshammer.autor.Autor;
import com.bitshammer.autor.dao.IAutorDao;

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
	 * @see com.bitshammer.autor.facade.IAutorFacade#save(com.bitshammer.autor.Autor)
	 */
	@Override
	public void save(Autor autor) {
		log.log(Level.INFO, "Entrou");
		dao.persist(autor);
		log.log(Level.INFO, "saiu");
	}

	/**
	 * (non-Javadoc)
	 * @see com.bitshammer.autor.facade.IAutorFacade#findByParams(com.bitshammer.autor.Autor)
	 */
	@Override
	public List<Autor> findByParams(Autor autor) {
		return dao.findByParams(autor);
	}

	@Override
	public List<Autor> listAll() {
		return dao.listAll();
	}

}
