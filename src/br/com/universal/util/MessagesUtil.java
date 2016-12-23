package br.com.universal.util;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessagesUtil {
	public static void inserirErro(String chave) {
		ResourceBundle rs = FacesContext.getCurrentInstance().getApplication().getResourceBundle(FacesContext.getCurrentInstance(), "msg");
		FacesMessage msg = new FacesMessage(rs.getString(chave));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
