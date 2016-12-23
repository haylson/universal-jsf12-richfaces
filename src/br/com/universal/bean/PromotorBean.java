package br.com.universal.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ajax4jsf.model.KeepAlive;
import org.springframework.dao.DataIntegrityViolationException;

import br.com.universal.model.Cidade;
import br.com.universal.model.Endereco;
import br.com.universal.model.Estado;
import br.com.universal.model.Pessoa;
import br.com.universal.model.Promotor;
import br.com.universal.model.enumeration.TipoPessoa;
import br.com.universal.service.inter.ICidadeService;
import br.com.universal.service.inter.IEstadoService;
import br.com.universal.service.inter.IPessoaService;
import br.com.universal.service.inter.IPromotorService;

@KeepAlive
public class PromotorBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4613003005926807543L;

	private IPromotorService promotorService;
	
	private IPessoaService pessoaService;
	
	private IEstadoService estadoService;
	
	private ICidadeService cidadeService;
	
	private Promotor promotor;
	
	private List<Promotor> listaPromotores;
	
	private List<Estado> listaEstados;
	
	private List<Cidade> listaCidades;
	
	@SuppressWarnings("unused")
	private List<String> listaTipoPessoa;
	
	public String preparaInserir(){
		promotor = new Promotor();
		listaEstados = estadoService.listarTodos();
		listaCidades = cidadeService.listarTodas();
		return "formPromotor";
	}
	
	public String preparaAtualizar(){
		promotor = promotorService.buscarPorId(promotor.getId());
		listaEstados = estadoService.listarTodos();
		listaCidades = cidadeService.listarTodas();
		return "formPromotor";
	}
	
	public String salvar(){
		try {
			if(promotor.getId() == null){
				promotorService.salvar(promotor);
			} else {
				promotorService.atualizar(promotor);
			}
		} catch (DataIntegrityViolationException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("CPF inválido...");
			context.addMessage("formPromotor", message);
			return null;
		}	
		return listar();
	}
	
	public String atualizar(){
		promotorService.atualizar(promotor);
		return listar();
	}
	
	public String apagar(){
		try {
			promotorService.apagar(promotor);
		} catch (DataIntegrityViolationException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("Existem clientes vinculados a esse promotor.");
			context.addMessage("formPromotor", message);
			return null;
		}
		return listar();
	}
	
	public String listar(){
		listaPromotores = promotorService.listarTodos();
		return "listPromotor";
	}
	
	public void carregaCidades() {
		listaCidades = cidadeService.findByEstadoId(promotor.getPessoa().getEndereco().getEstado().getId());
	}

	public IPromotorService getPromotorService() {
		return promotorService;
	}

	public void setPromotorService(IPromotorService promotorService) {
		this.promotorService = promotorService;
	}

	public IPessoaService getPessoaService() {
		return pessoaService;
	}

	public void setPessoaService(IPessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	public IEstadoService getEstadoService() {
		return estadoService;
	}

	public void setEstadoService(IEstadoService estadoService) {
		this.estadoService = estadoService;
	}

	public ICidadeService getCidadeService() {
		return cidadeService;
	}

	public void setCidadeService(ICidadeService cidadeService) {
		this.cidadeService = cidadeService;
	}

	public Promotor getPromotor() {
		if(promotor == null){
			promotor = new Promotor();
        }
       
        if(promotor.getPessoa() == null){
        	promotor.setPessoa(new Pessoa());
        }
       
        if(promotor.getPessoa().getEndereco() == null){
        	promotor.getPessoa().setEndereco(new Endereco());           
        }
       
        if(promotor.getPessoa().getEndereco().getEstado() == null){
        	promotor.getPessoa().getEndereco().setEstado(new Estado());           
        }
       
        if(promotor.getPessoa().getEndereco().getCidade() == null){
        	promotor.getPessoa().getEndereco().setCidade(new Cidade());           
        }
		return promotor;
	}

	public void setPromotor(Promotor promotor) {
		this.promotor = promotor;
	}

	public List<Promotor> getListaPromotores() {
		return listaPromotores;
	}

	public void setListaPromotores(List<Promotor> listaPromotores) {
		this.listaPromotores = listaPromotores;
	}

	public void setListaEstados(List<Estado> listaEstados) {
		this.listaEstados = listaEstados;
	}

	public List<Estado> getListaEstados() {
		return listaEstados;
	}

	public void setListaCidades(List<Cidade> listaCidades) {
		this.listaCidades = listaCidades;
	}

	public List<Cidade> getListaCidades() {
		return listaCidades;
	}

	public List<String> getListaTipoPessoa() {
		List<String> listTipoPessoa = new ArrayList<String>();
		for (TipoPessoa tipoPessoa : TipoPessoa.values()) {
			listTipoPessoa.add(tipoPessoa.toString());
		}
		return listTipoPessoa;
	}

	public void setListaTipoPessoa(List<String> listaTipoPessoa) {
		this.listaTipoPessoa = listaTipoPessoa;
	}
	
	

}
