package com.bitshammer.livro.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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

	private List<Autor> autores;

	private String[] selectedAutores;

	public LivroBean() {

	}

	public List<Autor> getAutores() {
		autores = new ArrayList<Autor>();
		Autor a = new Autor("Teste");
		Autor b = new Autor("Teste2");
		autores.add(a);
		autores.add(b);
		return autores;
	}

	public List<Categoria> getCategorias() {
		return Arrays.asList(Categoria.values());
	}

	public List<FormatoLivro> getFormatos() {
		return Arrays.asList(FormatoLivro.values());
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

}
