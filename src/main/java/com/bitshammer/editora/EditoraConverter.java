/**
 * 
 */
package com.bitshammer.editora;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * @author Bruno
 *
 */
@FacesConverter(value = "editoraConverter", forClass = Editora.class)
public class EditoraConverter implements Converter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.
	 * FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(FacesContext fc, UIComponent arg1, String value) {
		Editora editora = null;
		editora = EditoraMock.getInstance().listaEditora.stream().filter(e-> e.getId() == (Long.parseLong(value))).findFirst().orElse(editora);
		return editora;
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
			return String.valueOf(((Editora) object).getId());
		} else {
			return null;
		}
	}

}
