package br.com.universal.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import br.com.universal.dao.inter.IDao;

@Transactional(readOnly = true)
public class Dao<T, ID extends Serializable> implements IDao<T, ID> {
	
	private EntityManager entityManager;

	private final Class<T> entidade;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public Dao() {
		this.entidade = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	@Transactional(readOnly = false)
	public T atualizar(T object) {
		getEntityManager().merge(object);
		return object;
	}
	
	@Override
	@Transactional(readOnly = false)
	public void apagar(T object) {
		object = getEntityManager().merge(object);
		getEntityManager().remove(object);
	}
	
	@Override
	public T buscarPorId(ID id) {
		return (T) getEntityManager().find(entidade, id);
	}
	
	@Override
	@Transactional(readOnly = false)
	public T salvar(T object) {
		getEntityManager().clear();
		getEntityManager().persist(object);
		return object;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> listarTodos() {
		String queryS = "SELECT obj FROM " + entidade.getSimpleName() + " obj";
		Query query = getEntityManager().createQuery(queryS);
		return query.getResultList();
	}

	@Override
	public Class<T> getObjectClass() {
		// TODO Auto-generated method stub
		return this.entidade;
	}
	
}
