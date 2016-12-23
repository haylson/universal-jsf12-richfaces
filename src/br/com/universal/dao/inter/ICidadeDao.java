package br.com.universal.dao.inter;

import java.util.List;

import br.com.universal.model.Cidade;

public interface ICidadeDao {

	Cidade salvar(Cidade cidade);
	
	Cidade buscarPorId(Long id);
	
	void apagar(Cidade cidade);
	
	Cidade atualizar(Cidade cidade);
	
	List<Cidade> listarTodas();
	
	List<Cidade> buscar(String opcaoBusca,String valor);

	List<Cidade> findByEstadoId(Long id);
	
}
