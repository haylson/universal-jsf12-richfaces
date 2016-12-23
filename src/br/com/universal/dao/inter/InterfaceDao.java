package br.com.universal.dao.inter;

import java.io.Serializable;
import java.util.List;

public interface InterfaceDao<T> {
	void salvar(T bean);
	void atualizar(T bean);
	void excluir(T bean);
	T getBean(Serializable codigo);
	List<T> getBeans(); 
	
}
