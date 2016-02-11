package com.bitshammer.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * Classe que representa um Autor
 * @author Bruno
 *
 */
@Entity
public class Autor {

	@Id
	@GeneratedValue
	@Column(name="autor_id")
	private Long id;

	@Column(nullable=false, length=200)
	@NotNull(message="{nome.required}")
	private String nome;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(
		      name="autor_livro",
		      joinColumns={@JoinColumn(name="autor_id", referencedColumnName="autor_id")},
		      inverseJoinColumns={@JoinColumn(name="livro_id", referencedColumnName="livro_id")})
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
