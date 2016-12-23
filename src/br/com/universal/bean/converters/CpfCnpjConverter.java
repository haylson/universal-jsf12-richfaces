package br.com.universal.bean.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

public class CpfCnpjConverter implements Converter {

	public Object getAsObject(FacesContext context, UIComponent component,
			String value) throws ConverterException {
		/*
		 * Irá converter CPF formatado para um sem pontos e traço. Ex.:
		 * 355.245.198-87 torna-se 35524519887.
		 */
		String cpfCnpj = value;
		if (value != null && !value.equals("") && value.length() == 11) {
			cpfCnpj = value.replaceAll("\\.", "").replaceAll("\\-", "");
		} else if (value != null && !value.equals("") && value.length() == 14) {
			cpfCnpj = value.replaceAll("\\.", "").replaceAll("\\-", "")
					.replaceAll("/", "");

		}

		return cpfCnpj;
	}

	public String getAsString(FacesContext context, UIComponent component,
			Object value) throws ConverterException {
		/*
		 * Irá converter CPF não formatado para um com pontos e traço. Ex.:
		 * 35524519887 torna-se 355.245.198-87.
		 */
		String cpfCnpj = (String) value;
		if (cpfCnpj != null && cpfCnpj.length() == 11) {
			cpfCnpj = cpfCnpj.substring(0, 3) + "." + cpfCnpj.substring(3, 6)
					+ "." + cpfCnpj.substring(6, 9) + "-"
					+ cpfCnpj.substring(9, 11);
		} else if (cpfCnpj != null && cpfCnpj.length() == 14) {
			cpfCnpj = cpfCnpj.substring(0, 2) + "." + cpfCnpj.substring(2, 5)
					+ "." + cpfCnpj.substring(5, 8) + "/"
					+ cpfCnpj.substring(8, 12) + "-"
					+ cpfCnpj.substring(12, 14);
		}

		return cpfCnpj;
	}

}
