/**
 * 
 */
package com.bitshammer.livro.facade;

import java.util.List;

import com.bitshammer.livro.Livro;

/**
 * @author leticia.costa
 *
 */
public interface ILivroFacade {
	
	/**
	 * Grava um livro na base de
	 * dados
	 * @param livro Livro que será gravado
	 */
	void gravarLivro(Livro livro);

	List<Livro> pesquisarLivro(Livro livro);

	/**
	 * Atualiza um livro na base de 
	 * dados
	 * @param livro Livro que será atualizado
	 */
	void atualizarLivro(Livro livro);

	/**
	 * Exclui um livro da base de dados
	 * 
	 * @param livro
	 */
	void excluirLivro(Livro livro);

}
