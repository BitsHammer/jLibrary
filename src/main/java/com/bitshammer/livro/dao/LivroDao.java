package com.bitshammer.livro.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.bitshammer.autor.Autor;
import com.bitshammer.editora.Editora;
import com.bitshammer.infra.dao.JPADao;
import com.bitshammer.livro.Categoria;
import com.bitshammer.livro.Livro;

public class LivroDao extends JPADao<Livro> implements ILivroDao {
	@Override
	public List<Livro> pesquisarLivro(Livro livro) {
		
		EntityManager entityManager = getEntityManager();
	
		List<Autor> autor=livro.getAutores();
		Editora editora=livro.getEditora();
		List<Categoria> categorias=livro.getCategorias();
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Livro> query = builder.createQuery(Livro.class);
		Root<Livro> from = query.from(Livro.class);
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(autor != null && !autor.isEmpty())
			predicates.add(from.join("autores").in(autor));
		if(categorias != null && !categorias.isEmpty())
			predicates.add(from.join("categorias").in(categorias));
		
		if(editora != null && !"".equals(editora.getNome()))
			predicates.add(builder.equal(from.join("editora"), editora));
		if(livro.getTitulo() != null && !"".equals(livro.getTitulo()))
			predicates.add(builder.like(from.get("titulo"), "%" + livro.getTitulo() + "%"));
		
		
		Predicate[] arrPredicates = new Predicate[predicates.size()];
		for(int i=0; i<predicates.size();i++){
			arrPredicates[i] = predicates.get(i);
		}
		return entityManager.createQuery(query.select(from).where(arrPredicates).distinct(true)).getResultList();
		
	}
}
