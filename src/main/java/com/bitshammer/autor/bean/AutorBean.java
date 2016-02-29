/**
 * 
 */
package com.bitshammer.autor.bean;

import java.util.ArrayList;
import java.util.List;

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
	
	private List<Autor> autores;
	
	public AutorBean() {
		autor = new Autor();
		autores = new ArrayList<Autor>();
	}
	
	/**
	 * Salva um usuário na base
	 */
	public void salvar(){
		try{
			facade.save(autor);
			showSucessMessage();
		}catch(Exception e){
			addErrorMessage(e.getMessage());
		}
	}

	public void buscar(){
		autores = facade.listAll();
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

	/**
	 * @return the autores
	 */
	public List<Autor> getAutores() {
		buscar();
		return autores;
	}

	/**
	 * @param autores the autores to set
	 */
	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	
	

}
