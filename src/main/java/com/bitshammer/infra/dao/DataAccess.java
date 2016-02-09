package com.bitshammer.infra.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Classe para acesso a 
 * base de dados
 * @author Bruno
 *
 */
public abstract class DataAccess {
	
	private static EntityManager em;
	
	/**
	 * Construtor privado 
	 */
	protected DataAccess(){};
	
	
	protected EntityManager getEntityManager() {
		if(em == null){
			em = Persistence.createEntityManagerFactory("JLibrary").createEntityManager();
		}
		return em;
		
	}
	
	

}
