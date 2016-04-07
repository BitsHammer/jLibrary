/**
 * 
 */
package com.bitshammer.usuario.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.bitshammer.cliente.Cliente;
import com.bitshammer.cliente.facade.ClienteFacade;
import com.bitshammer.cliente.facade.IClienteFacade;
import com.bitshammer.infra.bean.DefaultBean;
import com.bitshammer.security.model.TipoUsuario;
import com.bitshammer.security.model.Usuario;
import com.bitshammer.usuario.facade.IUsuarioFacade;
import com.bitshammer.usuario.facade.UsuarioFacade;
import com.bitshammer.webservice.CepInvalidoException;
import com.bitshammer.webservice.ConsultaCepWebService;
import com.bitshammer.webservice.IConsultaCepWebService;

/**
 * @author Bruno
 *
 */
@ManagedBean
@ViewScoped
public class UsuarioBean extends DefaultBean {
	
	/**
	 * Cliente
	 */
	private Usuario usuario;
	
	/**
	 * Facade da classe Usuario
	 */
	private IUsuarioFacade facade;
	
	
	/**
	 * Construtor
	 */
	public UsuarioBean() {
		facade = new UsuarioFacade();
	}
	
	/**
	 * Cadastra um cliente
	 * @return
	 */
	public String cadastrarUsuario(){
		return "";
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
