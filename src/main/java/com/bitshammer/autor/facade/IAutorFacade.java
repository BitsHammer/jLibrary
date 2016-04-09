/**
 * 
 */
package com.bitshammer.autor.facade;

import java.util.List;

import com.bitshammer.autor.Autor;

/**
 * @author Bruno
 *
 */
public interface IAutorFacade {
	
	/**
	 * Grava um autor na base de
	 * dados
	 * @param autor Autor que será gravado
	 */
	void save(Autor autor);
	
	/**
	 * Encontra o autor através 
	 * dos parâmetros passados
	 * @param autor Autor
	 * @return Lista contendo os autoires que se encaixam nos parametros
	 */
	List<Autor> findByParams(Autor autor);
	
	/**
	 * Encontra todos os autores
	 * @return Lista contendo os autoires que se encaixam nos parametros
	 */
	List<Autor> listAll();

}
