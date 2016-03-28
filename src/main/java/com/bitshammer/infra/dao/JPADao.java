package com.bitshammer.infra.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
	 * Entity Manager Factory
	 */
	private static EntityManagerFactory factory;
	
	/**
	 * Construtor privado 
	 */
	protected JPADao(){};
	
	/**
	 * Singleton do entityManager
	 * @return {@link EntityManager} já criado previamente
	 */
	
	protected EntityManager getEntityManager() {
		return  EntityManagerSingleton.getInstance().createEntityManager();
		
	}
	
	/**
	 * Persiste um objeto na base
	 * de dados
	 * @param e {@link Object}
	 */
	public void persist(final T e){
		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(e);
		entityManager.getTransaction().commit();
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
		EntityManager entityManager = getEntityManager();
		return entityManager.find(clazz, id);
	}
	
	/**
	 * Deleta um objeto da base de dados
	 * 
	 * @param id
	 * @param clazz
	 * @return
	 */
	public void remove(final Long id, final Class<T> clazz){
		EntityManager entityManager = getEntityManager();
		entityManager.remove(find(id, clazz));
	}
	
}
