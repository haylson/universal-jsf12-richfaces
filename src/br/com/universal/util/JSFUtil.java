package br.com.universal.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.universal.model.Usuario;

public class JSFUtil {
	public static void inserirUsuarioSessao(Usuario u) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", u);
	}
	
	public static void removerUsuarioSessao(Usuario u) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("usuario");
	}
	
	public static Usuario obterUsuarioSessao() {
		return (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
	}
	
	public static void navegarLogin() {
		FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(FacesContext.getCurrentInstance(), null, "login");
	}
	
	public static String obterViewAtual() {
		return FacesContext.getCurrentInstance().getViewRoot().getViewId();
	}
	
	public static void encerrarSessao(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		session.invalidate();
	}
	
}
