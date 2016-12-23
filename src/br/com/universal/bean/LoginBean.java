package br.com.universal.bean;

import java.io.Serializable;

import br.com.universal.model.Usuario;
import br.com.universal.service.inter.IUsuarioService;
import br.com.universal.util.JSFUtil;
import br.com.universal.util.MessagesUtil;


public class LoginBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 162077429875084009L;

	private IUsuarioService usuarioService;

	private Usuario usuario = new Usuario();
	
	private boolean logado;
	
	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

/*	public String autenticar() {
		usuario.setLogin("universal");
		HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		httpSession.setAttribute("usu", usuario);
		return "index";
	}*/
	
	public String validateLogin() {
		try{
			usuario = usuarioService.findByLoginSenha(usuario.getLogin(), usuario.getSenha());
			JSFUtil.inserirUsuarioSessao(usuario);
		} catch(RuntimeException e) {
			MessagesUtil.inserirErro("erro.login");
			return null;
		}
		return "index";
	}
	
	public String logout(){
		JSFUtil.removerUsuarioSessao(usuario);
		JSFUtil.encerrarSessao();
		return "logout";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public IUsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(IUsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
}