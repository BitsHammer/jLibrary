/**
 * 
 */
package com.bitshammer.autor.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.bitshammer.autor.Autor;
import com.bitshammer.autor.facade.AutorFacade;
import com.bitshammer.autor.facade.IAutorFacade;
import com.bitshammer.infra.bean.DefaultBean;

/**
 * @author bruno.martins
 *
 */
@ManagedBean
@ViewScoped
public class AutorBean extends DefaultBean {

	private IAutorFacade facade = new AutorFacade();
	
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
