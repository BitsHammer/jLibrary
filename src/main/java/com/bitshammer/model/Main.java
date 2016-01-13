package com.bitshammer.model;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JLibrary");
		EntityManager entityManager = factory.createEntityManager();
		Editora e1 = new Editora();
		e1.setNome("Teste");
		entityManager.getTransaction().begin();
		entityManager.persist(e1);
		Autor autor = new Autor();
		autor.setNome("SK");
		entityManager.persist(autor);
		Livro livro = new Livro();
		livro.setAutores(Arrays.asList(autor));
		livro.setEditora(e1);
		livro.setNome("Dark Tower");
		livro.setQtdPaginas(999);
		entityManager.persist(livro);
		entityManager.getTransaction().commit();
		entityManager.close();
		System.exit(0);
		
	}

}
