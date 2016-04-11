package com.bitshammer.editora;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.bitshammer.comum.Endereco;
import com.bitshammer.livro.Livro;

/**
 * Classe que representa uma Editora
 * 
 * @author Bruno
 */
@Entity
public class Editora {

	/**
	 * CNPJ
	 */
	@Column
	private String cnpj;

	/**
	 * Endereco
	 */
	@Embedded
	private Endereco endereco;

	/**
	 * Id
	 */
	@Id
	@GeneratedValue
	@Column(name = "editora_id")
	private Integer id;

	/**
	 * Livros
	 */
	@OneToMany(mappedBy = "editora", fetch = FetchType.LAZY)
	private List<Livro> livros;

	/**
	 * Nome
	 */
	@Column(nullable = false)
	private String nome;

	/**
	 * Telefone
	 */
	@Column(nullable = false)
	private Long telefone;

	/**
	 * Construtor
	 */
	public Editora() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Construtor com sobrecarga
	 * 
	 * @param nome
	 */
	public Editora(String nome) {
		super();
		this.nome = nome;
	}

	/**
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * @return the endereco
	 */
	public Endereco getEndereco() {
		return endereco;
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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the telefone
	 */
	public Long getTelefone() {
		return telefone;
	}

	/**
	 * @param cnpj
	 *            the cnpj to set
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * @param endereco
	 *            the endereco to set
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @param telefone
	 *            the telefone to set
	 */
	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(id != null){
			return id.equals(((Editora)obj).getId());
		} else {
			return false;
		}
	}
}
