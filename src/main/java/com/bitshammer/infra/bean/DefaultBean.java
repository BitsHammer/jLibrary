package com.bitshammer.infra.bean;

import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;

public abstract class DefaultBean {

	protected void addMessage(String error) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", error);
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}

}
