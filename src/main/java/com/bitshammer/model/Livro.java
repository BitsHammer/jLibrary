package com.bitshammer.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * 
 * Classe que representa um livro
 * @author Bruno
 */
@Entity
public class Livro {
	
	@Id
	@Column(name="livro_id")
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false, length=200)
	private String nome;

	@Column(nullable=false)
	private int qtdPaginas;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="editora_id", referencedColumnName="editora_id")
	private Editora editora;

	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
	      name="autor_livro",
	      joinColumns={@JoinColumn(name="livro_id", referencedColumnName="livro_id")},
	      inverseJoinColumns={@JoinColumn(name="autor_id", referencedColumnName="autor_id")})
	private List<Autor> autores;

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
	 * @return the qtdPaginas
	 */
	public int getQtdPaginas() {
		return qtdPaginas;
	}

	/**
	 * @param qtdPaginas the qtdPaginas to set
	 */
	public void setQtdPaginas(int qtdPaginas) {
		this.qtdPaginas = qtdPaginas;
	}

	/**
	 * @return the editora
	 */
	public Editora getEditora() {
		return editora;
	}

	/**
	 * @param editora the editora to set
	 */
	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	/**
	 * @return the autores
	 */
	public List<Autor> getAutores() {
		return autores;
	}

	/**
	 * @param autores the autores to set
	 */
	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

}
