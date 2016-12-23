package br.com.universal.bean.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

public class CepConverter implements Converter{

	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
        /*
         * Irá converter CEF formatado para um sem pontos e traço.
         * Ex.: 60.000-00 torna-se 6000000.
         */
         String cep = value;
         if (value!= null && !value.equals(""))
              cep = value.replaceAll("\\.", "").replaceAll("\\-", "");

         return cep;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
        /*
         * Irá converter CEP não formatado para um com pontos e traço.
         * Ex.: 6000000 torna-se 60.000-00.
         */
         String cep = (String) value;
         if (cep != null && cep.length() == 8)
              cep = cep.substring(0, 2) + "." + cep.substring(2, 5) + "-" + cep.substring(5, 8);

         return cep;
	}
	
}
