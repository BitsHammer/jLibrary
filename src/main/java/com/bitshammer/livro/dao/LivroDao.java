package com.bitshammer.livro.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.bitshammer.autor.Autor;
import com.bitshammer.editora.Editora;
import com.bitshammer.infra.dao.JPADao;
import com.bitshammer.livro.Categoria;
import com.bitshammer.livro.Livro;

public class LivroDao extends JPADao<Livro> implements ILivroDao {
	@Override
	public List<Livro> pesquisarLivro(Livro livro) {
		
		EntityManager entityManager = getEntityManager();
		
		String where="";
		
		List<Autor> autor=livro.getAutores();
		Editora editora=livro.getEditora();
		List<Categoria> categorias=livro.getCategorias();
		
		if(!editora.equals("")){
			where=where+"l.editora p WHERE l.editora.id = :id";
		}
		
		//if(where!=""){
			TypedQuery<Livro> query = entityManager
					.createQuery("SELECT l FROM Livro l JOIN l.editora p WHERE l.editora.id = :id", Livro.class);
			query.setParameter("id", 10);
		//}else{
			
		//}
		System.out.println(query.getResultList());
		return query.getResultList();	
	}
}
