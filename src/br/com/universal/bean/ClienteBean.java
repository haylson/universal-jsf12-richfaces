package br.com.universal.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ajax4jsf.model.KeepAlive;
import org.springframework.dao.DataIntegrityViolationException;

import br.com.universal.model.Cidade;
import br.com.universal.model.Cliente;
import br.com.universal.model.Endereco;
import br.com.universal.model.Estado;
import br.com.universal.model.Pessoa;
import br.com.universal.model.Promotor;
import br.com.universal.model.enumeration.TipoPessoa;
import br.com.universal.service.inter.ICidadeService;
import br.com.universal.service.inter.IClienteService;
import br.com.universal.service.inter.IEstadoService;
import br.com.universal.service.inter.IPessoaService;
import br.com.universal.service.inter.IPromotorService;

@KeepAlive
public class ClienteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7812032239145284856L;

	private IClienteService clienteService;
	
	private IEstadoService estadoService;
	
	private ICidadeService cidadeService;
	
	private IPessoaService pessoaService;
	
	private IPromotorService promotorService;
	
	private Cliente cliente;
	
	private String opcaoBusca;
	
	private String valor;
	
	private List<Cliente> listaClientes;
	
	private List<Estado> listaEstados;
	
	private List<Cidade> listaCidades;
	
	private List<Promotor> listaPromotores;
	
	@SuppressWarnings("unused")
	private List<String> listaTipoPessoa;
	
	private boolean tipoPessoaFisica = true;
	
	public String preparaInserir(){
		cliente = new Cliente();
		cliente.getPessoa().setDataDeCadastro(new Date());
		cliente.getPessoa().setTipoPessoa(TipoPessoa.valueOf("FISICA"));
		listaPromotores = promotorService.listarTodos();
		listaEstados = estadoService.listarTodos();
		listaCidades = cidadeService.listarTodas();
		tipoPessoaFisica = true;
		return "formCliente";
	}
	
	public String preparaAtualizar(){
		cliente = clienteService.buscarPorId(cliente.getId());
		listaPromotores = promotorService.listarTodos();
		listaEstados = estadoService.listarTodos();
		listaCidades = cidadeService.listarTodas();
		return "formCliente";
	}
	
	public String salvar(){
		try {
			if(cliente.getId() == null){
				clienteService.salvar(cliente);
			}else{
				clienteService.atualizar(cliente);
			}
		} catch (DataIntegrityViolationException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("CPF já cadastrado.");
			context.addMessage("formCliente", message);
			return null;
		}
		return listar();
	}
	
	public String atualizar(){
		clienteService.atualizar(cliente);
		return listar();
	}
	
	public String apagar(){
		clienteService.apagar(cliente);
		return listar();
	}
	
	public String listar(){
		listaClientes = clienteService.listarTodos();
        return "listCliente";
	}
	
	public void buscar(){
		listaClientes = clienteService.buscar(opcaoBusca, valor);
	}
	
	public void carregaCidades() {
		listaCidades = cidadeService.findByEstadoId(cliente.getPessoa().getEndereco().getEstado().getId());
	}
	
	public void trocarTipoPessoa() {
		if (cliente.getPessoa().getTipoPessoa().equals(TipoPessoa.FISICA)) {
			tipoPessoaFisica = true;
		} else {
			tipoPessoaFisica = false;
		}
	}
	
	public IClienteService getClienteService() {
		return clienteService;
	}

	public void setClienteService(IClienteService clienteService) {
		this.clienteService = clienteService;
	}

	public Cliente getCliente() {
        if(cliente == null){
            cliente = new Cliente();
        }
       
        if(cliente.getPessoa() == null){
            cliente.setPessoa(new Pessoa());
        }
       
        if(cliente.getPessoa().getEndereco() == null){
            cliente.getPessoa().setEndereco(new Endereco());           
        }
       
        if(cliente.getPessoa().getEndereco().getEstado() == null){
            cliente.getPessoa().getEndereco().setEstado(new Estado());           
        }
       
        if(cliente.getPessoa().getEndereco().getCidade() == null){
            cliente.getPessoa().getEndereco().setCidade(new Cidade());           
        }
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public List<Estado> getListaEstados() {
		return listaEstados;
	}

	public void setListaEstados(List<Estado> listaEstados) {
		this.listaEstados = listaEstados;
	}

	public List<Cidade> getListaCidades() {
		return listaCidades;
	}

	public void setListaCidades(List<Cidade> listaCidades) {
		this.listaCidades = listaCidades;
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

	public IPessoaService getPessoaService() {
		return pessoaService;
	}

	public void setPessoaService(IPessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	public void setListaTipoPessoa(List<String> listaTipoPessoa) {
		this.listaTipoPessoa = listaTipoPessoa;
	}

	public List<String> getListaTipoPessoa() {
		List<String> listTipoPessoa = new ArrayList<String>();
		for (TipoPessoa tipoPessoa : TipoPessoa.values()) {
			listTipoPessoa.add(tipoPessoa.toString());
		}
		return listTipoPessoa;
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

	public void setListaPromotores(List<Promotor> listaPromotores) {
		this.listaPromotores = listaPromotores;
	}

	public List<Promotor> getListaPromotores() {
		return listaPromotores;
	}

	public void setPromotorService(IPromotorService promotorService) {
		this.promotorService = promotorService;
	}

	public IPromotorService getPromotorService() {
		return promotorService;
	}

	public boolean isTipoPessoaFisica() {
		return tipoPessoaFisica;
	}

	public void setTipoPessoaFisica(boolean tipoPessoaFisica) {
		this.tipoPessoaFisica = tipoPessoaFisica;
	}
	
}
