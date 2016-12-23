package br.com.universal.dao.inter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface IDaoGenerico<T, ID extends Serializable> {
	
	public Class<T> getObjectClass();
	public T salvar(T object);
	public T atualizar(T object);
	public void apagar(T object);
	public T buscarPorId(ID id);
	public List<T> listarTodos();
	public List<T> listPesqParam(String query, Map<String, Object> params);
	public List<T> listPesqParam(String query, Map<String, Object> params, int maximo, int atual);
	public List<T> listPesq(String query);
	public T pesqParam(String query, Map<String, Object> params);

}
