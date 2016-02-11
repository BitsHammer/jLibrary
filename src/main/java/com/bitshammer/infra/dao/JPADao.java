package com.bitshammer.infra.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Classe para acesso a 
 * base de dados
 * @author Bruno
 * @param <T>
 *
 */
public abstract class JPADao<T> {
	
	/**
	 * Entity Manager
	 */
	private static EntityManager em;
	
	/**
	 * Construtor privado 
	 */
	protected JPADao(){};
	
	/**
	 * Singleton do entityManager
	 * @return {@link EntityManager} já criado previamente
	 */
	protected EntityManager getEntityManager() {
		if(em == null){
			em = Persistence.createEntityManagerFactory("JLibrary").createEntityManager();
		}
		return em;
		
	}
	
	/**
	 * Persiste um objeto na base
	 * de dados
	 * @param e {@link Object}
	 */
	public void persist(final T e){
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(e);
		getEntityManager().getTransaction().commit();
	}
	
	/**
	 * Procura por um determinado
	 * objeto na base de dados
	 * 
	 * @param id
	 * @param clazz
	 * @return
	 */
	public T find(final Long id, final Class<T> clazz){
		return getEntityManager().find(clazz, id);
	}
	
}
