package com.bitshammer.livro.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.bitshammer.autor.Autor;
import com.bitshammer.autor.AutorMock;
import com.bitshammer.cliente.Cliente;
import com.bitshammer.editora.Editora;
import com.bitshammer.editora.EditoraMock;
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
	
	private Livro selectLivro = new Livro();
	
	private List<Autor> listaAutor= new ArrayList<>();
	
	private List<Editora> listaEditora= new ArrayList<>();
	
	/**
	 * Lista de livro
	 */
	private List<Livro> listaLivro= new ArrayList<>();

	public LivroBean() {
		listaAutor = AutorMock.getInstance().listaAutor;
		listaEditora = EditoraMock.getInstance().listaEditora;
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
		try{
			facade.gravarLivro(livro);
			addMessage("Sucesso", "Livro Cadastrado com Sucesso.");
			livro = new Livro();
		}catch(Exception e){
			showErrorMessage("Erro ao efetivar o cadastro!");
		}	

	}
	
	 public void setSelectedLivro(Livro livro) {
	        this.selectLivro = livro;	
	 }
	 
	 public Livro getSelectedLivro() {
	        return selectLivro;
	 }
	 
	public void pesquisaLivro(){
		try{
			listaLivro = facade.pesquisarCliente(livro);
			if(listaLivro.isEmpty())
				showErrorMessage("Nenhum livro encontrado!");
		}catch(Exception e){
			showErrorMessage("Erro ao pesquisar livro!");
		}
	}

	public List<Livro> getListaLivro() {
		return listaLivro;
	}

	public void setListaLivro(List<Livro> listaLivro) {
		this.listaLivro = listaLivro;
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

	/**
	 * @return the listaEditora
	 */
	public List<Editora> getListaEditora() {
		return listaEditora;
	}

}
