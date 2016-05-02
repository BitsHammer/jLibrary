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
	
	/**
	 * Persiste um livro
	 * @param l
	 */
	void persist(Livro l);

	/**
	 * Pesquisa um livro
	 * @param livro
	 * @return
	 */
	List<Livro> pesquisarLivro(Livro livro);

	/**
	 * Atualiza um livro
	 * @param livro
	 */
	void update(Livro livro);

	/**
	 * Exclui um livro
	 * @param livro
	 */
	void remove(Livro livro);	

}
