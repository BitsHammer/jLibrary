/**
 * 
 */
package com.bitshammer.livro.facade;

import java.util.List;

import com.bitshammer.livro.Livro;

/**
 * @author bruno.martins
 *
 */
public interface ILivroFacade {
	
	/**
	 * Grava um livro na base de
	 * dados
	 * @param livro Livro que será gravado
	 */
	void gravarLivro(Livro livro);

	List<Livro> pesquisarCliente(Livro livro);

}
