package com.bitshammer.autor.dao;

import java.util.List;

import com.bitshammer.model.Autor;


public interface IAutorDao {

	void persist(final Autor autor);

	List<Autor> findByParams(Autor autor);
	
	List<Autor> listAll();


}
