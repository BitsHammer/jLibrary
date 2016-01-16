/**
 * 
 */
package com.bitshammer.security.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.security.auth.login.LoginException;

import com.bitshammer.security.dao.ILoginDao;
import com.bitshammer.security.model.Role;
import com.bitshammer.security.model.Usuario;

/**
 * @author Bruno
 *
 */
public final class LoginDao implements ILoginDao {

	
	/* (non-Javadoc)
	 * @see com.bitshammer.security.dao.ILoginDao#findUser(java.lang.String, java.lang.String)
	 */
	@Override
	public Usuario findUser(String name, String password) throws LoginException {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JLibrary");
		EntityManager entityManager = factory.createEntityManager();
		Query query = entityManager.createQuery("select u from Ususario as u where u.login = :login and u.senha = :senha", Usuario.class);
		query.setParameter("login", name);
		query.setParameter("senha", password);
		@SuppressWarnings("unchecked")
		List<Usuario> resultList = query.getResultList();
		entityManager.close();
		if(!resultList.isEmpty()){
			return resultList.get(0);
		} else {
			throw new LoginException();
		}
	}

	/* (non-Javadoc)
	 * @see com.bitshammer.security.dao.ILoginDao#findRoles(com.bitshammer.security.model.Usuario)
	 */
	@Override
	public List<Role> findRoles(Usuario user) {
		// TODO Auto-generated method stub
		return null;
	}

}
