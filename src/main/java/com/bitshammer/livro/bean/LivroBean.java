package com.bitshammer.livro.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hibernate.loader.custom.Return;

import com.bitshammer.infra.bean.DefaultBean;
import com.bitshammer.livro.Livro;
import com.bitshammer.livro.facade.ILivroFacade;
import com.bitshammer.livro.facade.LivroFacade;
import com.bitshammer.security.facade.ILoginFacade;
import com.bitshammer.security.facade.LoginFacade;
import com.bitshammer.security.model.Usuario;



/**
 * @author Letícia Soares
 *
 */

@ManagedBean
@ViewScoped
public class LivroBean extends DefaultBean {
	
	private ILivroFacade facade = new LivroFacade();
	
	private Livro livro = new Livro();
	
	private List<String> autores;
	
	private String[] selectedAutores;
	
	public LivroBean(){
		
	}
	
	
	public List<String> getAutores() {
		autores = new ArrayList<String>();
		autores.add("Leticia");
		autores.add("Bruno");       
		return autores;
		
    }
	
	public String[] getSelectedAutores() {
        return selectedAutores;
    }
 
    public void setSelectedAutores(String[] selectedAutores) {
        this.selectedAutores = selectedAutores;
    } 
    
    /**
	 * @return the usuario
	 */
	public Livro getLivro() {
		return livro;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
    
	
}
