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
 * @author Bruno
 *
 */
@Entity
public class Autor{

	@Id
	@GeneratedValue
	@Column(name="autor_id")
	private Long id;

	@Column(nullable=false, length=200)
	private String nome;
	
	/**
	 * Data de nascimento
	 */
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dtNascimento;
	
	/**
	 * Data do possível falecimento
	 */
	@Temporal(TemporalType.DATE)
	private Date dtFalecimento;
	
	/**
	 * Local do nascimento
	 */
	@Column
	private String localNascimento;
	
	/**
	 * Local do da morte
	 */
	@Column
	private String localMorte;

	/**
	 * Biografia
	 */
	@Column
	private String biografia;
	
	
	public Autor(String nome) {
		super();
		this.nome = nome;
	}
	
	public Autor() {
		// TODO Auto-generated constructor stub
	}

	@ManyToMany(fetch=FetchType.LAZY)
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

	/**
	 * @return the dtNascimento
	 */
	public Date getDtNascimento() {
		return dtNascimento;
	}

	/**
	 * @param dtNascimento the dtNascimento to set
	 */
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	/**
	 * @return the dtFalecimento
	 */
	public Date getDtFalecimento() {
		return dtFalecimento;
	}

	/**
	 * @param dtFalecimento the dtFalecimento to set
	 */
	public void setDtFalecimento(Date dtFalecimento) {
		this.dtFalecimento = dtFalecimento;
	}

	/**
	 * @return the localNascimento
	 */
	public String getLocalNascimento() {
		return localNascimento;
	}

	/**
	 * @param localNascimento the localNascimento to set
	 */
	public void setLocalNascimento(String localNascimento) {
		this.localNascimento = localNascimento;
	}

	/**
	 * @return the localMorte
	 */
	public String getLocalMorte() {
		return localMorte;
	}

	/**
	 * @param localMorte the localMorte to set
	 */
	public void setLocalMorte(String localMorte) {
		this.localMorte = localMorte;
	}

	/**
	 * @return the biografia
	 */
	public String getBiografia() {
		return biografia;
	}

	/**
	 * @param biografia the biografia to set
	 */
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	
	/*@Override
	public int hashCode() {
		return id.intValue();
	}*/
	
	@Override
	public boolean equals(Object obj) {
		return id.equals(((Autor)obj).getId());
	}

}
