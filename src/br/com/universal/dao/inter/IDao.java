package br.com.universal.dao.inter;

import java.io.Serializable;
import java.util.List;

public interface IDao<T, ID extends Serializable> {
	
	public Class<T> getObjectClass();
	public T salvar(T object);
	public T atualizar(T object);
	public void apagar(T object);
	public T buscarPorId(ID id);
	public List<T> listarTodos();

}
