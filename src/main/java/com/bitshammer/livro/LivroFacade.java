package com.bitshammer.livro;

import java.util.List;

import com.bitshammer.model.Livro;

public interface LivroFacade {
	
	void persist(Livro l);
	
	Livro findById(Integer id);
	
	List<Livro> findByParams(Livro l);
	
	List<Livro> findAll(Livro l);

}
