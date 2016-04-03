package com.bitshammer.cliente;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.bitshammer.security.model.Usuario;

/**
 * Classe que representa um Cliente
 * 
 * @author Bruno
 *
 */
@Entity
public class Cliente {

	@Id
	@GeneratedValue
	@Column(name = "cliente_id")
	private Long id;

	/**
	 * Nome
	 */
	@Column(nullable = false, length = 200)
	private String nome;

	/**
	 * Telefone
	 */
	@Column(nullable = false, length = 8)
	private String telefone;

	/**
	 * Celular
	 */
	@Column(nullable = false, length = 9)
	private String celular;
	
	/**
	 * Data de nascimento
	 */
	@Temporal(TemporalType.TIME)
	private Date dtNascimento;
	
	/**
	 * Sexo
	 */
	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	/**
	 * Endereco
	 */
	@Embedded
	private String endereco;

	/**
	 * Usuário
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private Usuario usuario;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
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
	 * @param nome
	 *            the nome to set
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
	 * @param telefone
	 *            the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * @param celular
	 *            the celular to set
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

}
