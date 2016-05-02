/**
 * 
 */
package com.bitshammer.autor.facade;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.bitshammer.autor.Autor;
import com.bitshammer.autor.dao.AutorDao;
import com.bitshammer.autor.dao.IAutorDao;
import com.bitshammer.infra.logger.LoggerProducer;

/**
 * @author Bruno
 *
 */
public class AutorFacade implements IAutorFacade {

	private IAutorDao dao = new AutorDao();
	
	private Logger log = LoggerProducer.produceLogger(getClass());
	
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
