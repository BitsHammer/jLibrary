package com.bitshammer.livro.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.bitshammer.infra.dao.JPADao;
import com.bitshammer.livro.Livro;

public class LivroDao extends JPADao<Livro> implements ILivroDao {
	@Override
	public List<Livro> pesquisarLivro(Livro livro) {
		EntityManager entityManager = getEntityManager();

		TypedQuery<Livro> query = entityManager
				.createQuery("select livro from Livro as livro", Livro.class);
		//query.setParameter("nome", "%" + livro.getNome() + "%");
		return query.getResultList();	
	}
}
