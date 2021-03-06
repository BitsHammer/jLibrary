/**
 * 
 */
package com.bitshammer.infra.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author leticia.costa
 *
 */
public class EntityManagerSingleton {
	
	private static EntityManagerFactory INSTANCE;
	
	
	private EntityManagerSingleton(){
	}
	
	public static EntityManagerFactory getInstance(){
		if(INSTANCE == null){
			INSTANCE = Persistence.createEntityManagerFactory("JLibrary");
		}
		return INSTANCE;
	}

}
