package com.bitshammer.livro.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpSession;

import org.hibernate.loader.custom.Return;

import com.bitshammer.autor.Autor;
import com.bitshammer.infra.bean.DefaultBean;
import com.bitshammer.livro.Categoria;
import com.bitshammer.livro.FormatoLivro;
import com.bitshammer.livro.Livro;
import com.bitshammer.livro.facade.ILivroFacade;
import com.bitshammer.livro.facade.LivroFacade;

/**
 * @author Letícia Soares
 *
 */

@ManagedBean
@ViewScoped
public class LivroBean extends DefaultBean {

	private ILivroFacade facade = new LivroFacade();

	private Livro livro = new Livro();
	
	private List<Autor> listaAutor= new ArrayList<>();

	public LivroBean() {
		Autor a = new Autor("Teste");
		a.setId(1l);
		Autor b = new Autor("Teste2");
		b.setId(2l);
		listaAutor.add(a);
		listaAutor.add(b);
	}

	public List<Categoria> getCategorias() {
		return Arrays.asList(Categoria.values());
	}

	public List<FormatoLivro> getFormatos() {
		return Arrays.asList(FormatoLivro.values());
	}

	/**
	 * @return the usuario
	 */
	public Livro getLivro() {
		return livro;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public void gravarLivro() {
		facade.gravarLivro(livro);
		addMessage("Sucesso", "Livro Cadastrado com Sucesso.");

	}

	/**
	 * @return the listaAutor
	 */
	public List<Autor> getListaAutor() {
		return listaAutor;
	}

	/**
	 * @param listaAutor the listaAutor to set
	 */
	public void setListaAutor(List<Autor> listaAutor) {
		this.listaAutor = listaAutor;
	}

}
