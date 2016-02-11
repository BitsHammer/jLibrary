package com.bitshammer.infra.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;

public abstract class DefaultBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2162113209886252134L;

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

}
