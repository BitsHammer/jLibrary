/**
 * 
 */
package com.bitshammer.livro.facade;

import com.bitshammer.livro.Livro;

/**
 * @author bruno.martins
 *
 */
public interface ILivroFacade {
	
	/**
	 * Grava um livro na base de
	 * dados
	 * @param livro Livro que ser� gravado
	 */
	void gravarLivro(Livro livro);

}
