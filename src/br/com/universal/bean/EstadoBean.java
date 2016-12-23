package br.com.universal.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;

import org.ajax4jsf.model.KeepAlive;
import org.richfaces.component.html.HtmlDataTable;
import org.springframework.dao.DataIntegrityViolationException;

import br.com.universal.model.Estado;
import br.com.universal.service.inter.IEstadoService;
import br.com.universal.service.inter.IUsuarioService;

@KeepAlive
public class EstadoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2595435773131473257L;

	private IEstadoService estadoService;

	private IUsuarioService usuarioService;

	private Estado estado;

	private List<Estado> listaEstados;

	private String opcaoBusca;

	private String valor;

	private Long id;

	private String user;

	private DataModel dataModel;
	
	private HtmlDataTable htmlDataTable;

	public String preparaInserir() {
		estado = new Estado();
		listaEstados = estadoService.listarTodos();
		return "formEstado";
	}

	public String preparaAtualizar() {
		estado = estadoService.buscarPorId(estado.getId());
		return "formEstado";
	}

	public String salvar() {
		if (estado.getId() == null) {
			estadoService.salvar(estado);
		} else {
			estadoService.atualizar(estado);
		}
		return listar();
	}

	public String atualizar() {
		estadoService.atualizar(estado);
		return listar();
	}

	public String apagar() {
		try {
			estadoService.apagar(estado);
		} catch (DataIntegrityViolationException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("Não foi possivel realizar a exclusao.");
			context.addMessage("formEstado", message);
			return null;
		}
		return listar();
	}

	public String listar() {
		listaEstados = estadoService.listarTodos();
		return "listEstado";
	}

	public void buscar() {
		listaEstados = estadoService.buscar(opcaoBusca, valor);
	}

	public void buscarPorId() {
		estado = estadoService.buscarPorId(id);
	}

	public IEstadoService getEstadoService() {
		return estadoService;
	}

	public void setEstadoService(IEstadoService estadoService) {
		this.estadoService = estadoService;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getListaEstados() {
		if (listaEstados == null) {
			listaEstados = estadoService.listarTodos();
		}
		return listaEstados;
	}

	public void setListaEstados(List<Estado> listaEstados) {
		this.listaEstados = listaEstados;
	}

	public String getOpcaoBusca() {
		return opcaoBusca;
	}

	public void setOpcaoBusca(String opcaoBusca) {
		this.opcaoBusca = opcaoBusca;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUser() {
		return user;
	}

	public void setUsuarioService(IUsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public IUsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setDataModel(DataModel dataModel) {
		this.dataModel = dataModel;
	}

	public DataModel getDataModel() {
		return dataModel;
	}

	public void setHtmlDataTable(HtmlDataTable htmlDataTable) {
		this.htmlDataTable = htmlDataTable;
	}

	public HtmlDataTable getHtmlDataTable() {
		return htmlDataTable;
	}

}