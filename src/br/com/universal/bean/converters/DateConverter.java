package br.com.universal.bean.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

public class DateConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
        /*
         * Irá converter DATA formatado para um sem pontos e traço.
         * Ex.: 01/01/2010 torna-se 01012010.
         */
         String data = value;
         if (value!= null && !value.equals(""))
              data = value.replaceAll("\\.", "").replaceAll("\\-", "");

         return data;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
        /*
         * Irá converter DATA não formatado para um com pontos e traço.
         * Ex.: 01012010 torna-se 01/01/2010.
         */
         String data = (String) value;
         if (data != null && data.length() == 8)
             data = data.substring(0, 2) + "\\" + data.substring(2, 4) + "\\" + data.substring(4, 8);

         return data;
	}

}
