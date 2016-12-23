package br.com.universal.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Locale;

import javax.faces.context.FacesContext;

import org.ajax4jsf.model.KeepAlive;

@KeepAlive
public class UtilBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4547626925814985656L;
	private Date data = new Date();
	
	public static void alterarLinguagem(String lingua){
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(lingua));
	}
	
	public static void alterarLinguagemPortugues(){
		alterarLinguagem("pt");
	}
	
	public static void alterarLinguagemIngles(){
		alterarLinguagem("en");
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getData() {
		return data;
	}

}
