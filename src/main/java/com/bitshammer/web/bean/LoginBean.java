/**
 * 
 */
package com.bitshammer.web.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.bitshammer.model.Usuario;

/**
 * @author Bruno
 *
 */
@ManagedBean
@RequestScoped
public class LoginBean {
	
	private Usuario usuario;
	
	public LoginBean() {
		usuario = new Usuario();
	}
	
	public String login(){
		System.out.println(usuario);
		return "/sistema.xhtml";
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
