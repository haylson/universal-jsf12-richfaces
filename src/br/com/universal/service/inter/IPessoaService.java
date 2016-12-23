package br.com.universal.service.inter;

import java.util.List;

import br.com.universal.model.Pessoa;

public interface IPessoaService {
	
	Pessoa salvar(Pessoa pessoa);
	
	Pessoa buscarPorId(Long id);
	
	void apagar(Pessoa pessoa);
	
	Pessoa atualizar(Pessoa pessoa);
	
	List<Pessoa> listarTodas();

}
