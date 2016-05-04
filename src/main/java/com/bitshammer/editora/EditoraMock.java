package com.bitshammer.editora;

import java.util.List;

import javax.persistence.EntityManager;

import com.bitshammer.infra.dao.EntityManagerSingleton;

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
			Editora editora2 = new Editora();
			editora2.setNome("From Hell");
			editora2.setTelefone(666l);
			editora2.setCnpj("666");
			entityManager.getTransaction().begin();
			entityManager.persist(editora);
			entityManager.persist(editora2);
			entityManager.getTransaction().commit();
			listaEditora.add(editora);
			listaEditora.add(editora2);
		}
	}

	public static EditoraMock getInstance(){
		if(INSTANCE == null)
			INSTANCE = new EditoraMock();
		return INSTANCE;
	}
}
