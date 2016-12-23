package br.com.universal.dao.inter;

import java.util.List;

import br.com.universal.model.Cliente;

public interface IClienteDao {
	
	Cliente salvar(Cliente cliente);
	
	Cliente buscarPorId(Long id);
	
	void apagar(Cliente cliente);
	
	Cliente atualizar(Cliente cliente);
	
	List<Cliente> listarTodos();

	List<Cliente> buscar(String opcaoBusca, String valor);

}
