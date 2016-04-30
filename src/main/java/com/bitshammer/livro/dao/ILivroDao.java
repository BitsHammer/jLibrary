/**
 * 
 */
package com.bitshammer.livro.dao;

import java.util.List;

import com.bitshammer.livro.Livro;

/**
 * @author bruno.martins
 *
 */
public interface ILivroDao {
	
	void persist(Livro l);

	List<Livro> pesquisarLivro(Livro livro);	

}
