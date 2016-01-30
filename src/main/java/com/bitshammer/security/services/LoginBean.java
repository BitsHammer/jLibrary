/**
 * 
 */
package com.bitshammer.security.services;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.auth.login.LoginException;

import com.bitshammer.infra.bean.DefaultBean;
import com.bitshammer.security.facade.ILoginFacade;
import com.bitshammer.security.model.Usuario;

/**
 * @author Bruno
 *
 */
@Named
@RequestScoped
public class LoginBean extends DefaultBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4166072776920035348L;

	@Inject
	private ILoginFacade facade;
	
	private Usuario usuario = new Usuario();
	
	public LoginBean(){
		
	}
	
	public void logar() throws LoginException{
		try{	
			facade.login(usuario);
		}catch(LoginException e){
			addMessage(e.getMessage());
		}
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
