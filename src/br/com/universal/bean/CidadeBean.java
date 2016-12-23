package br.com.universal.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ajax4jsf.model.KeepAlive;
import org.springframework.dao.DataIntegrityViolationException;

import br.com.universal.model.Cidade;
import br.com.universal.model.Estado;
import br.com.universal.service.inter.ICidadeService;
import br.com.universal.service.inter.IEstadoService;

@KeepAlive
public class CidadeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3887147110684536488L;

	private ICidadeService cidadeService;
	
	private IEstadoService estadoService;

	private Cidade cidade;
	
	private Estado estado;
	
	private List<Cidade> listaCidades;
	
	private List<Estado> listaEstados;
	
	private String opcaoBusca;
	
	private String valor;
	
	private Long id;
	
	public String preparaInserir(){
		cidade = new Cidade();
		estado = new Estado();
		listaEstados = estadoService.listarTodos();
		return "formCidade";
	}
	
	public String preparaAtualizar(){
		cidade = cidadeService.buscarPorId(cidade.getId());
		return "formCidade";
	}
	
	public String salvar(){
		if(cidade.getId() == null){
			cidadeService.salvar(cidade);
		}else{
			cidadeService.atualizar(cidade);
		}
		return listar();
	}
	
	public String atualizar(){
		cidadeService.atualizar(cidade);
		return listar();
	}
	
	public String apagar(){
		try {
			cidadeService.apagar(cidade);
		} catch (DataIntegrityViolationException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("Não foi possivel realizar a exclusao.");
			context.addMessage("formCidade", message);
			return null;
		}
		return listar();
	}
	
	public String listar(){
		listaCidades =  cidadeService.listarTodas();
        return "listCidade";
	}
	
	public void buscarPorId(){
		cidade = cidadeService.buscarPorId(id);
	}
	
	public void buscar(){
		listaCidades = cidadeService.buscar(opcaoBusca, valor);
	}

	public ICidadeService getCidadeService() {
		return cidadeService;
	}

	public void setCidadeService(ICidadeService cidadeService) {
		this.cidadeService = cidadeService;
	}

	public Cidade getCidade() {
		 if(cidade == null){
			 	cidade = new Cidade();
	     }
	       
	     if(cidade.getEstado() == null){
	            cidade.setEstado(new Estado());
	     }
	     return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getListaCidades() {
		return listaCidades;
	}

	public void setListaCidades(List<Cidade> listaCidades) {
		this.listaCidades = listaCidades;
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

	public void setEstadoService(IEstadoService estadoService) {
		this.estadoService = estadoService;
	}

	public IEstadoService getEstadoService() {
		return estadoService;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setListaEstados(List<Estado> listaEstados) {
		this.listaEstados = listaEstados;
	}

	public List<Estado> getListaEstados() {
		return listaEstados;
	}
	
}