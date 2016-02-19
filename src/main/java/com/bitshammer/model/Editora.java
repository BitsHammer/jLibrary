package com.bitshammer.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Classe que representa uma Editora
 * @author Bruno
 */
@Entity
public class Editora {

	@Id
	@GeneratedValue
	@Column(name="editora_id")
	private Long id;

	@Column(nullable=false)
	private String nome;
	
	public Editora(String nome) {
		super();
		this.nome = nome;
	}
	
	public Editora() {
		// TODO Auto-generated constructor stub
	}

	@OneToMany(mappedBy="editora", fetch=FetchType.LAZY)
	private List<Livro> livros;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the livros
	 */
	public List<Livro> getLivros() {
		return livros;
	}

	/**
	 * @param livros the livros to set
	 */
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

}
