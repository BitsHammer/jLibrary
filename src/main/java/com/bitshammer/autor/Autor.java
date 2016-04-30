package com.bitshammer.autor;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bitshammer.livro.Livro;

/**
 * Classe que representa um Autor
 * 
 * @author Bruno
 *
 */
@Entity
public class Autor {

	/**
	 * Biografia
	 */
	@Column
	private String biografia;

	/**
	 * Data do possível falecimento
	 */
	@Temporal(TemporalType.DATE)
	private Date dtFalecimento;

	/**
	 * Data de nascimento
	 */
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dtNascimento;

	/**
	 * ID
	 */
	@Id
	@GeneratedValue
	@Column(name = "autor_id")
	private Integer id;

	/**
	 * Livros
	 */
	@ManyToMany
	@JoinTable(name = "autor_livro", joinColumns = {
			@JoinColumn(name = "autor_id", referencedColumnName = "autor_id") }, inverseJoinColumns = {
					@JoinColumn(name = "livro_id", referencedColumnName = "livro_id") })
	private List<Livro> livros;

	/**
	 * Local do da morte
	 */
	@Column
	private String localMorte;

	/**
	 * Local do nascimento
	 */
	@Column
	private String localNascimento;

	/**
	 * Nome
	 */
	@Column(nullable = false, length = 200)
	private String nome;

	/**
	 * Construtor
	 */
	public Autor() {
	}

	/**
	 * Construtor
	 * 
	 * @param nome
	 */
	public Autor(String nome) {
		super();
		this.nome = nome;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(this.id == null)
			return false;
		return id.equals(((Autor) obj).getId());
	}

	/**
	 * @return the biografia
	 */
	public String getBiografia() {
		return biografia;
	}

	/**
	 * @return the dtFalecimento
	 */
	public Date getDtFalecimento() {
		return dtFalecimento;
	}

	/**
	 * @return the dtNascimento
	 */
	public Date getDtNascimento() {
		return dtNascimento;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the livros
	 */
	public List<Livro> getLivros() {
		return livros;
	}

	/**
	 * @return the localMorte
	 */
	public String getLocalMorte() {
		return localMorte;
	}

	/**
	 * @return the localNascimento
	 */
	public String getLocalNascimento() {
		return localNascimento;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param biografia
	 *            the biografia to set
	 */
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	/**
	 * @param dtFalecimento
	 *            the dtFalecimento to set
	 */
	public void setDtFalecimento(Date dtFalecimento) {
		this.dtFalecimento = dtFalecimento;
	}

	/**
	 * @param dtNascimento
	 *            the dtNascimento to set
	 */
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param livros
	 *            the livros to set
	 */
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	/**
	 * @param localMorte
	 *            the localMorte to set
	 */
	public void setLocalMorte(String localMorte) {
		this.localMorte = localMorte;
	}

	/**
	 * @param localNascimento
	 *            the localNascimento to set
	 */
	public void setLocalNascimento(String localNascimento) {
		this.localNascimento = localNascimento;
	}

	/*
	 * @Override public int hashCode() { return id.intValue(); }
	 */

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

}
