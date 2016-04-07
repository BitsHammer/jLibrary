/**
 * 
 */
package com.bitshammer.categoria.facade;

import java.util.List;

import com.bitshammer.categoria.Categoria;

/**
 * @author Bruno
 *
 */
public interface ICategoriaFacade {

	public void cadastrarCategoria(Categoria categoria);
	
	public void alterarCategoria(Categoria categoria);
	
	public void excluirCategoria(Categoria categoria);
	
	public List<Categoria> listarCategoriaPorParametros(Categoria categoria);
		
}
