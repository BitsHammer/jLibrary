/**
 * 
 */
package com.bitshammer.security.services;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpSession;

import com.bitshammer.infra.bean.DefaultBean;
import com.bitshammer.security.facade.ILoginFacade;
import com.bitshammer.security.facade.LoginFacade;
import com.bitshammer.security.model.Usuario;

/**
 * @author Bruno
 *
 */
@ManagedBean
@ViewScoped
public class LoginBean extends DefaultBean{

	private ILoginFacade facade;
	
	
	private Usuario usuario;
	
	public LoginBean(){
		usuario = new Usuario();
		facade = new LoginFacade();
	}
	
	/**
	 * Loga o usuário
	 * @return
	 * @throws LoginException
	 */
	public String logar() throws LoginException{
		try{	
			facade.login(usuario);
			return "home";
		}catch(LoginException e){
			showErrorMessage(e.getMessage());
		}
		return "";
	}
	
	/**
	 * Loga o usuário
	 * @return
	 * @throws LoginException
	 */
	public String logOff() throws LoginException{
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.removeAttribute("usuario");
		session.removeAttribute("cliente");
		session.invalidate();
		return "login";
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
