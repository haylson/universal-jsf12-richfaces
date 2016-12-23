package br.com.universal.service.inter;

import java.util.List;

import br.com.universal.model.Promotor;

public interface IPromotorService {
	
	Promotor salvar(Promotor promotor);
	
	Promotor atualizar(Promotor promotor);
	
	Promotor buscarPorId(Long id);
	
	void apagar(Promotor promotor);
	
	List<Promotor> listarTodos();

}
