/**
 * 
 */
package com.bitshammer.security.model;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

/**
 * 
 * Classe representando um Usuario
 * @author Bruno
 *
 */
/**
 * @author Bruno
 *
 */
@Entity
public class Usuario implements Principal {
	
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private Long id;
	
	@Column(nullable=false, length=50)
	private String login;
	
	@Column(nullable=false)
	private String senha;
	
	@Column(nullable=false, length=50)
	private String email;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(
		      name="user_roles",
		      joinColumns={@JoinColumn(name="user_id", referencedColumnName="user_id")},
		      inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="role_id")})
	private List<Role> roles = new ArrayList<Role>();

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
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
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
	 * @param senha the senha to set
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
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/* (non-Javadoc)
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

	@Override
	public String getName() {
		return login;
	}

	/**
	 * @return the roles
	 */
	public List<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
