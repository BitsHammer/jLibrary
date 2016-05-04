package com.bitshammer.autor;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.bitshammer.infra.dao.EntityManagerSingleton;

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
				Autor b = new Autor();
				
				b.setNome("SK");
				b.setBiografia("Biografia 2");
				b.setDtFalecimento(new Date());
				b.setDtNascimento(new Date());
				b.setLocalMorte("Morreu aqui");
				b.setLocalNascimento("Nasceu?");
				entityManager.getTransaction().begin();
				entityManager.persist(a);
				entityManager.persist(b);
				entityManager.getTransaction().commit();
				listaAutor.add(a);
				listaAutor.add(b);
		}
	}

	public static AutorMock getInstance(){
		if(INSTANCE == null)
			INSTANCE = new AutorMock();
		return INSTANCE;
	}
}
