package com.bitshammer.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Classe que representa um Cliente
 * @author Bruno
 *
 */
@Entity
public class Cliente {

	@Id
	@GeneratedValue
	@Column(name="cliente_id")
	private Long id;
	
	@Column(nullable=false, length=200)
	private String nome;

	@Column(nullable=false, length=8)
	private String telefone;

	@Column(nullable=false, length=50)
	private String email;

	@Column(nullable=false, length=9)
	private String celular;
	
	@OneToMany(mappedBy="cliente_id", fetch=FetchType.LAZY)
	private List<Aluguel> alugueis;

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
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * @param celular the celular to set
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

	/**
	 * @return the alugueis
	 */
	public List<Aluguel> getAlugueis() {
		return alugueis;
	}

	/**
	 * @param alugueis the alugueis to set
	 */
	public void setAlugueis(List<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}

}
