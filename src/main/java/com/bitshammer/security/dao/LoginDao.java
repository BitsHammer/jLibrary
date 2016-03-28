/**
 * 
 */
package com.bitshammer.security.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.security.auth.login.LoginException;

import com.bitshammer.infra.dao.JPADao;
import com.bitshammer.security.model.Usuario;

/**
 * @author Bruno
 *
 */
public class LoginDao extends JPADao<Usuario> implements ILoginDao {
	
	/**
	 * @see com.bitshammer.security.dao.ILoginDao#findUser(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public Usuario findUser(Usuario usuario) throws LoginException {
		EntityManager entityManager = getEntityManager();
		
		TypedQuery<Usuario> query = entityManager.createQuery("select u from Usuario as u where u.login = :login and u.senha = :senha",
				Usuario.class);
		query.setParameter("login", usuario.getLogin());
		query.setParameter("senha", usuario.getSenha());
		
		List<Usuario> resultList = query.getResultList();
		if (!resultList.isEmpty()) {
			return resultList.get(0);
		} else {
			throw new LoginException("Usuario nao encontrado");
		}
		
	}

}
