package br.com.universal.service.inter;

import java.util.List;

import br.com.universal.model.Cliente;

public interface IClienteService {
	
	Cliente salvar(Cliente cliente);
	
	Cliente buscarPorId(Long id);
	
	void apagar(Cliente cliente);
	
	Cliente atualizar(Cliente cliente);
	
	List<Cliente> listarTodos();

	List<Cliente> buscar(String opcaoBusca, String valor);

}
