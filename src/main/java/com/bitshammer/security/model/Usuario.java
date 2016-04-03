/**
 * 
 */
package com.bitshammer.security.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

	/**
	 * Id
	 */
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Integer id;

	/**
	 * Login
	 */
	@Column(nullable = false, length = 50)
	private String login;

	/**
	 * Senha
	 */
	@Column(nullable = false, length=6)
	private String senha;

	/**
	 * Email
	 */
	@Column(nullable = false, length = 50)
	private String email;

	/**
	 * Tipo de Usuario
	 */
	@Enumerated(EnumType.ORDINAL)
	private TipoUsuario tipoUsuario;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
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
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		return id.equals(((Usuario)obj).getId());
	}
}
