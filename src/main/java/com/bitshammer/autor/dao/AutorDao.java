package com.bitshammer.autor.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import com.bitshammer.infra.dao.JPADao;
import com.bitshammer.model.Autor;

class AutorDao extends JPADao<Autor> implements IAutorDao{

	@Override
	public List<Autor> findByParams(Autor autor) {
		String str = "select a from Autor a  where a.nome = :name";
		TypedQuery<Autor> query = getEntityManager().createQuery(str, Autor.class);
		query.setParameter("name", autor.getNome());
		return query.getResultList();
	}

	@Override
	public List<Autor> listAll() {
		String str = "select a from Autor a";
		TypedQuery<Autor> query = getEntityManager().createQuery(str, Autor.class);
		return query.getResultList();
	}


}
