package com.bitshammer.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DataAccess {
	
	private static EntityManagerFactory factory = null;
	
	protected static EntityManager getEntityManager(){
		if(factory == null){
			factory = Persistence.createEntityManagerFactory("JLibrary");
		}
		return factory.createEntityManager();
		
	}
}
