package br.com.universal.bean.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

public class FoneConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
        /*
         * Irá converter Fone formatado para um sem pontos e traço.
         * Ex.: (85)9999-8888 torna-se 8599998888.
         */
         String fone = value;
         if (value!= null && !value.equals(""))
              fone = value.replace('(', ' ').replace(')', ' ').replaceAll("[ ./-]", "");

         return fone;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
        /*
         * Irá converter CPF não formatado para um com pontos e traço.
         * Ex.: 8599998888 torna-se (85)9999-8888.
         */
         String fone = (String) value;
         if (fone != null && fone.length() == 10)
              fone = "(" + fone.substring(0, 2) + ")" + fone.substring(2, 6) + "-" + fone.substring(6, 10);

         return fone;
	}


}
