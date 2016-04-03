/**
 * 
 */
package com.bitshammer.autor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * @author Bruno
 *
 */
@FacesConverter(value = "autorConverter", forClass = Autor.class)
public class AutorConverter implements Converter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.
	 * FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(FacesContext fc, UIComponent arg1, String value) {
		Autor autor = null;
		autor = AutorMock.getInstance().listaAutor.stream().filter(e-> e.getId().equals(Long.parseLong(value))).findFirst().orElse(autor);
		return autor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.
	 * FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
		if (object != null) {
			return String.valueOf(((Autor) object).getId());
		} else {
			return null;
		}
	}

}
