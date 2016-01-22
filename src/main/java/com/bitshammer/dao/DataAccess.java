package com.bitshammer.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bitshammer.security.model.Role;
import com.bitshammer.security.model.Usuario;

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
	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JLibrary");
		EntityManager entityManager = factory.createEntityManager();
		Usuario user = new Usuario();
		user = entityManager.find(Usuario.class, 2L);
		System.out.println(user);
		System.out.println(user.getRoles());
		System.exit(0);
		
		
	}
	

}
