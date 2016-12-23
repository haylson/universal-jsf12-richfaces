package br.com.universal.service.inter;

import java.util.List;

import br.com.universal.model.Estado;

public interface IEstadoService {
	
	Estado salvar(Estado estado);
	
	Estado buscarPorId(Long id);
	
	void apagar(Estado estado);
	
	Estado atualizar(Estado estado);
	
	List<Estado> listarTodos();
	
	List<Estado> buscar(String opcaoBusca,String valor);

}