package br.com.universal.bean;

import java.io.Serializable;
import java.util.List;

import org.ajax4jsf.model.KeepAlive;

import br.com.universal.model.Pessoa;
import br.com.universal.service.inter.IPessoaService;

@KeepAlive
public class PessoaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6319903722532323444L;

	private IPessoaService pessoaService;
	
	private Pessoa pessoa;
	
	private List<Pessoa> listaPessoas;
	
	public String preparaInserir(){
		pessoa = new Pessoa();
		return "formPessoa";
	}
	
	public String preparaAtualizar(){
		pessoa = pessoaService.buscarPorId(pessoa.getId());
		return "formPessoa";
	}
	
	public String salvar(){
		if(pessoa.getId() == null){
			pessoaService.salvar(pessoa);
		}else{
			pessoaService.atualizar(pessoa);
		}
		return listar();
	}
	
	public String atualizar(){
		pessoaService.atualizar(pessoa);
		return listar();
	}
	
	public String apagar(){
		pessoaService.apagar(pessoa);
		return listar();
	}
	
	public String listar(){
		listaPessoas =  pessoaService.listarTodas();
        return "listPessoa";
	}

	public IPessoaService getPessoaService() {
		return pessoaService;
	}

	public void setPessoaService(IPessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getListaPessoas() {
		return listaPessoas;
	}

	public void setListaPessoas(List<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}
	
}
