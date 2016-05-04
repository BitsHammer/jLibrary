/**
 * 
 */
package com.bitshammer.autor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.bitshammer.infra.dao.EntityManagerSingleton;

/**
 * @author Bruno
 *
 */
@FacesConverter(value = "autorConverter")
public class AutorConverter implements Converter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.
	 * FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(FacesContext fc, UIComponent arg1, String value) {
		return EntityManagerSingleton.getInstance().createEntityManager().find(Autor.class, Integer.parseInt(value));
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
