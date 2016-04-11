package com.bitshammer.editora;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bitshammer.infra.dao.EntityManagerSingleton;
import com.bitshammer.infra.dao.JPADao;

public class EditoraMock {
	
	private static EditoraMock INSTANCE;  
	
	public List<Editora> listaEditora; 
	
	private EditoraMock(){
		EntityManager entityManager = EntityManagerSingleton.getInstance().createEntityManager();
		listaEditora = entityManager.createQuery("select e from Editora as e", Editora.class).getResultList();
		if(listaEditora.isEmpty()){
			Editora editora = new Editora();
			editora.setNome("Empresa Sombra");
			editora.setTelefone(29435002l);
			editora.setCnpj("435983928000169");
			entityManager.getTransaction().begin();
			entityManager.persist(editora);
			entityManager.getTransaction().commit();
			listaEditora.add(editora);
		}
	}

	public static EditoraMock getInstance(){
		if(INSTANCE == null)
			INSTANCE = new EditoraMock();
		return INSTANCE;
	}
}
