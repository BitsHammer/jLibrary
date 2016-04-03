/**
 * 
 */
package com.bitshammer.security.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 
 * Classe representando um Usuario
 * 
 * @author Bruno
 *
 */
@Entity
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4196937487888694691L;

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Long id;

	@Column(nullable = false, length = 50)
	private String login;

	@Column(nullable = false)
	private String senha;

	@Column(nullable = false, length = 50)
	private String email;

	@Enumerated(EnumType.ORDINAL)
	private TipoUsuario tipoUsuario;

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
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha
	 *            the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [id=");
		builder.append(id);
		builder.append(", login=");
		builder.append(login);
		builder.append(", senha=");
		builder.append(senha);
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the tipoUsuario
	 */
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	/**
	 * @param tipoUsuario
	 *            the tipoUsuario to set
	 */
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
}
