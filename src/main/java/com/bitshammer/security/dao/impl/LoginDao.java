/**
 * 
 */
package com.bitshammer.security.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.security.auth.login.LoginException;

import com.bitshammer.dao.DataAccess;
import com.bitshammer.security.dao.ILoginDao;
import com.bitshammer.security.model.Usuario;

/**
 * @author Bruno
 *
 */
public final class LoginDao extends DataAccess implements ILoginDao {

	
	/**
	 * @see com.bitshammer.security.dao.ILoginDao#findUser(java.lang.String, java.lang.String)
	 */
	@Override
	public Usuario findUser(String name, String password) throws LoginException {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select u from Usuario as u where u.login = :login and u.senha = :senha", Usuario.class);
		query.setParameter("login", name);
		query.setParameter("senha", password);
		List<Usuario> resultList = query.getResultList();
		if(!resultList.isEmpty()){
			return resultList.get(0);
		} else {
			throw new LoginException();
		}
	}	

}
