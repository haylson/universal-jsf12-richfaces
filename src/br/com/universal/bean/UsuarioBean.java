package br.com.universal.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ajax4jsf.model.KeepAlive;
import org.springframework.dao.DataIntegrityViolationException;

import br.com.universal.model.Usuario;
import br.com.universal.service.inter.IUsuarioService;

@KeepAlive
public class UsuarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7083105582190834597L;

	private IUsuarioService usuarioService;
	
	private Usuario usuario;
	
	private Long id;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	private List<Usuario> listaUsuarios;
	
	public String preparaInserir(){
		usuario = new Usuario();
		listaUsuarios = usuarioService.listarTodas();
		return "formUsuario";
	}
	
	public String preparaAtualizar(){
		usuario = usuarioService.buscarPorId(usuario.getId());  
		return "formUsuario";
	}
	
	public String salvar(){
		if(usuario.getId() == null){
			usuarioService.salvar(usuario);
		}else{
			usuarioService.atualizar(usuario);
		}
		return listar();
	}
	
	public String atualizar(){
		usuarioService.atualizar(usuario);
		return listar();
	}
	
	public String apagar(){
		try {
			usuarioService.apagar(usuario);
		} catch (DataIntegrityViolationException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("Não foi possivel realizar a exclusao.");
			context.addMessage("formUsuario", message);
			return null;
		}
		return listar();
	}
	
	public String listar(){
		listaUsuarios =  usuarioService.listarTodas();
        return "listUsuario";
	}
	
	public void buscarPorId(){
		usuario = usuarioService.buscarPorId(id);
	}

	public IUsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(IUsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

}