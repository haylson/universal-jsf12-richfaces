package br.com.universal.dao.inter;

import java.util.List;

import br.com.universal.model.Promotor;

public interface IPromotorDao {
	
	Promotor salvar(Promotor promotor);
	
	Promotor atualizar(Promotor promotor);
	
	Promotor buscarPorId(Long id);
	
	void apagar(Promotor promotor);
	
	List<Promotor> listarTodos();

}
