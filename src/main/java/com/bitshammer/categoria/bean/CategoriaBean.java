/**
 * 
 */
package com.bitshammer.categoria.bean;

import java.util.List;

import com.bitshammer.categoria.Categoria;
import com.bitshammer.categoria.facade.CategoriaFacade;
import com.bitshammer.categoria.facade.ICategoriaFacade;
import com.bitshammer.infra.bean.DefaultBean;

/**
 * @author Bruno
 *
 */
public class CategoriaBean extends DefaultBean {
	
	
	private Categoria categoria;
	
	private List<Categoria> listaCategoria;
	
	private ICategoriaFacade facade;
	
	public CategoriaBean() {
		facade = new CategoriaFacade();
		categoria = new Categoria();
	}
	
	public String cadastrarCategoria(){
		return "";
	}
	
	public void alterarCategoria(){
		
	}
	
	public String excluirCategoria(){
		return "";
	}
	
	public void listarCategoria(){
		
	}

}
