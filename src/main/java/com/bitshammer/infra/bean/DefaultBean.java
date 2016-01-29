package com.bitshammer.infra.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;

public abstract class DefaultBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2162113209886252134L;

	protected void addMessage(String error) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", error);
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}

}
