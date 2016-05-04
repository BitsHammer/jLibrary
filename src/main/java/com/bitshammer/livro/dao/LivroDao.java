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
	
		List<Autor> autor=livro.getAutores();
		Editora editora=livro.getEditora();
		List<Categoria> categorias=livro.getCategorias();
		
		StringBuilder where=new StringBuilder();
		StringBuilder join=new StringBuilder();
		
		if(editora!=null){
			where.append("L.editora = :editora");			
		}
		if(categorias!=null && !categorias.isEmpty()){
			join.append(" INNER JOIN L.categorias c");
			if(!where.equals("")){				
				where.append(" AND c IN :categorias");				
			}else{
				where.append("c IN :categorias");
			}
		}	
		if(autor!=null && !autor.isEmpty()){
			join.append(" INNER JOIN L.autores a");
			if(!where.equals("")){				
				where.append(" AND a IN :autor");				
			}else{
				where.append("a IN :autor");
			}
		}
		
		if(livro.getTitulo()!=null && !"".equals(livro.getTitulo())){			
			if(!where.equals("")){				
				where.append(" AND L.titulo= :titulo");				
			}else{
				where.append("L.titulo= :titulo");
			}
		}
		
		String whereC=where.toString();
		String joinC=join.toString();
		
		StringBuilder select=new StringBuilder();
		
		if(!joinC.equals("")){
			select.append(joinC);
		}
		
		if(!whereC.equals("")){
			select.append(" WHERE "+whereC);
		}
		
		String selectC=select.toString();
		
		System.out.println("QUERY MONTADA"+select);
		if(!select.equals("")){
			TypedQuery<Livro> query = entityManager
					.createQuery("SELECT L FROM Livro L "+selectC, Livro.class);
			if(editora!=null)
				query.setParameter("editora",editora);
			if(autor!=null && !autor.isEmpty())
				query.setParameter("autor", autor);
			if(categorias!=null && !categorias.isEmpty())
				query.setParameter("categorias", categorias);
			if(livro.getTitulo()!=null && !"".equals(livro.getTitulo()))
				query.setParameter("titulo", livro.getTitulo());
			
			return query.getResultList();	
		}else{
			TypedQuery<Livro> query = entityManager
					.createQuery("SELECT L FROM Livro L", Livro.class);		
			
			return query.getResultList();	
		}
		
		
		/*TypedQuery<Livro> query = entityManager
				.createQuery("SELECT L FROM Livro L INNER JOIN L.autores a INNER JOIN L.categorias c WHERE L.editora = :editora AND a IN :autor AND c IN :categorias", Livro.class);
		query.setParameter("editora", editora);
		query.setParameter("autor", autor);
		query.setParameter("categorias", categorias);
		query.setParameter("titulo", livro.getTitulo());*/
		
	}
}
