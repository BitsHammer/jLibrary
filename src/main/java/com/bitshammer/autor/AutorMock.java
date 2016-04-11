package com.bitshammer.autor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bitshammer.infra.dao.EntityManagerSingleton;
import com.bitshammer.infra.dao.JPADao;

public class AutorMock {
	
	private static AutorMock INSTANCE;  
	
	public List<Autor> listaAutor; 
	
	private AutorMock(){
		EntityManager entityManager = EntityManagerSingleton.getInstance().createEntityManager();
		listaAutor = entityManager.createQuery("select a from Autor as a", Autor.class).getResultList();
		if(listaAutor.isEmpty()){
				Autor a = new Autor();
				a.setNome("George RR Martin");
				a.setBiografia("Biografia");
				a.setDtFalecimento(new Date());
				a.setDtNascimento(new Date());
				a.setLocalMorte("Aqui");
				a.setLocalNascimento("Lá");
				entityManager.getTransaction().begin();
				entityManager.persist(a);
				entityManager.getTransaction().commit();
				listaAutor.add(a);
		}
	}

	public static AutorMock getInstance(){
		if(INSTANCE == null)
			INSTANCE = new AutorMock();
		return INSTANCE;
	}
}
