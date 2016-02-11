/**
 * 
 */
package com.bitshammer.autor.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.bitshammer.autor.facade.IAutorFacade;
import com.bitshammer.infra.bean.DefaultBean;
import com.bitshammer.model.Autor;

/**
 * @author bruno.martins
 *
 */
@Named
@RequestScoped
public class AutorBean extends DefaultBean {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IAutorFacade facade;
	
	private Autor autor;
	
	public AutorBean() {
		// TODO Auto-generated constructor stub
	}
	
	public void salvar(){
		facade.save(autor);
	}

	/**
	 * @return the autor
	 */
	public Autor getAutor() {
		return autor;
	}

	/**
	 * @param autor the autor to set
	 */
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	

}
