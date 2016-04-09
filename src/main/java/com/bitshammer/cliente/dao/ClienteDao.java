/**
 * 
 */
package com.bitshammer.cliente.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.bitshammer.cliente.Cliente;
import com.bitshammer.infra.dao.JPADao;
import com.bitshammer.security.model.Usuario;

/**
 * @author Bruno
 *
 */
public class ClienteDao extends JPADao<Cliente> implements IClienteDao {

	@Override
	public Cliente findByUser(Usuario usuario) {
		EntityManager entityManager = getEntityManager();

		TypedQuery<Cliente> query = entityManager
				.createQuery("select c from Cliente as c where usuario = :usuario", Cliente.class);
		query.setParameter("usuario", usuario);

		List<Cliente> resultList = query.getResultList();
		if (!resultList.isEmpty())
			return resultList.get(0);
		return null;
	}

}
