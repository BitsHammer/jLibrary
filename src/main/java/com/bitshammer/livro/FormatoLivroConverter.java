package com.bitshammer.livro;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "formatoLivroConverter")
public class FormatoLivroConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		return FormatoLivro.byId(Integer.parseInt(value));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
		if (object != null) {
			FormatoLivro formato = (FormatoLivro) object;
			return String.valueOf(formato.getId());
		} else {
			return null;
		}
	}

}
