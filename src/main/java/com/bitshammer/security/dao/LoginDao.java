/**
 * 
 */
package com.bitshammer.security.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.security.auth.login.LoginException;

import com.bitshammer.security.model.Usuario;

/**
 * @author Bruno
 *
 */
class LoginDao implements ILoginDao {

	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * @see com.bitshammer.security.dao.ILoginDao#findUser(java.lang.String, java.lang.String)
	 */
	@Override
	public Usuario findUser(Usuario usuario) throws LoginException {
		Query query = em.createQuery("select u from Usuario as u where u.login = :login and u.senha = :senha", Usuario.class);
		query.setParameter("login", usuario.getLogin());
		query.setParameter("senha", usuario.getSenha());
		List<Usuario> resultList = query.getResultList();
		if(!resultList.isEmpty()){
			return resultList.get(0);
		} else {
			throw new LoginException();
		}
	}	

}
