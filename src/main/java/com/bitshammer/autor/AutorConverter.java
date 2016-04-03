/**
 * 
 */
package com.bitshammer.autor;

import java.util.Optional;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.bitshammer.livro.bean.LivroBean;

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
		if (value != null && value.trim().length() > 0) {
			LivroBean bean = (LivroBean) fc.getViewRoot().getViewMap().get("livroBean");
			for(Autor t : bean.getListaAutor()){
				if(t.getId().equals(Long.parseLong(value)))
					autor = t;
			}
		}
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
