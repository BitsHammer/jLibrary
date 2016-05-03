/**
 * 
 */
package com.bitshammer.cliente.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.bitshammer.cliente.Cliente;
import com.bitshammer.infra.dao.JPADao;
import com.bitshammer.security.model.Usuario;

/**
 * @author Bruno
 *
 */
public class ClienteDao extends JPADao<Cliente> implements IClienteDao {

	/*
	 * (non-Javadoc)
	 * @see com.bitshammer.cliente.dao.IClienteDao#findByUser(com.bitshammer.security.model.Usuario)
	 */
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

	/*
	 * (non-Javadoc)
	 * @see com.bitshammer.cliente.dao.IClienteDao#pesquisarCliente(com.bitshammer.cliente.Cliente)
	 */
	@Override
	public List<Cliente> pesquisarCliente(Cliente cliente) {
		EntityManager entityManager = getEntityManager();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Cliente> query = builder.createQuery(Cliente.class);
		Root<Cliente> from = query.from(Cliente.class);
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(cliente.getNome() != null)
			predicates.add(builder.equal(from.get("nome"), cliente.getNome()));
		
		if(cliente.getCpf() != null)
			predicates.add(builder.equal(from.get("cpf"), cliente.getCpf()));
		if(cliente.getUsuario().getEmail() != null)
			predicates.add(builder.equal(from.join("usuario").get("email"), cliente.getUsuario().getEmail()));
		
		Predicate[] arrPredicates = new Predicate[predicates.size()];
		for(int i=0; i<predicates.size();i++){
			arrPredicates[i] = predicates.get(i);
		}
		return entityManager.createQuery(query.select(from).where(arrPredicates)).getResultList();
		
		
	}

}
