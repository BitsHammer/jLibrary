package com.bitshammer.infra.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import com.bitshammer.security.model.TipoUsuario;
import com.bitshammer.security.model.Usuario;

public abstract class DefaultBean{


	/**
	 * Exibe uma mensagem de informação ao usuário
	 * 
	 * @param title Título da mensagem
	 * @param detail Detalhe da mensagem
	 */
	protected void addMessage(String title, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, title, detail);
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	
	/**
	 * Exibe uma mensagem de erro ao usuário
	 * @param error Mensagem
	 */
	protected void addErrorMessage(String error) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", error);
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	

	protected void showSucessMessage() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Dados salvos!");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	
	/**
	 * Valida se há um usuário comum na aplicação
	 * @return
	 */
	public boolean isUsuarioCliente(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		if(session.getAttribute("usuario") != null){
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			return TipoUsuario.CLIENTE.equals(usuario.getTipoUsuario());			
		}
		return true;
	}
	
	/**
	 * Valida se há um usuário administrador na aplicação
	 * @return
	 */
	public boolean isUsuarioAdministrador(){
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		if(session.getAttribute("usuario") != null){
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			return TipoUsuario.ADMINISTRADOR.equals(usuario.getTipoUsuario());			
		}
		return false;
	}

}
