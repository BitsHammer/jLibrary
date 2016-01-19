package com.bitshammer.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DataAccess {
	
	private EntityManagerFactory factory = null;
	
	private EntityManager manager;
	
	public EntityManager getEntityManager(){
		if(factory == null){
			factory = Persistence.createEntityManagerFactory("JLibrary");
		}
		if(manager == null){
			manager = factory.createEntityManager();
		}
		return manager; 
	}
	

}
