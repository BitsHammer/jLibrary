/**
 * 
 */
package com.bitshammer.security.services;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.security.auth.login.LoginException;

import com.bitshammer.security.dao.ILoginDao;
import com.bitshammer.security.facade.ILoginFacade;
import com.bitshammer.security.facade.LoginFacade;
import com.bitshammer.security.model.Usuario;

/**
 * @author Bruno
 *
 */
@ManagedBean
@ViewScoped
public class LoginBean extends com.bitshammer.infra.bean.DefaultBean{

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
