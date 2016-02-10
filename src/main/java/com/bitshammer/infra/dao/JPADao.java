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
	
	private static EntityManager em;
	
	/**
	 * Construtor privado 
	 */
	protected JPADao(){};
	
	
	protected EntityManager getEntityManager() {
		if(em == null){
			em = Persistence.createEntityManagerFactory("JLibrary").createEntityManager();
		}
		return em;
		
	}
	
	public void persist(final T e){
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(e);
		getEntityManager().getTransaction().commit();
	}
	
	

}
