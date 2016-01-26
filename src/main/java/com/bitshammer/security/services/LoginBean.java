/**
 * 
 */
package com.bitshammer.security.services;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.security.auth.login.LoginException;

import com.bitshammer.bean.DefaultBean;
import com.bitshammer.security.dao.ILoginDao;
import com.bitshammer.security.dao.impl.LoginDao;
import com.bitshammer.security.model.Usuario;

/**
 * @author Bruno
 *
 */
@ManagedBean
@ViewScoped
public class LoginBean extends DefaultBean{

	
	private ILoginDao dao = new LoginDao();
	
	private Usuario usuario = new Usuario();
	
	public LoginBean(){
		
	}
	
	public void logar() throws LoginException{
		try{	
			usuario = dao.findUser(usuario.getName(), usuario.getSenha());
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