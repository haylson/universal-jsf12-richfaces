package br.com.universal.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.universal.dao.inter.IDaoGenerico;

@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class DaoGenericoImpl<T, ID extends Serializable> implements
		IDaoGenerico<T, ID> {

	private EntityManager entityManager;

	private final Class<T> oClass;

	@Override
	public Class<T> getObjectClass() {
		return this.oClass;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	protected EntityManager getEntityManager() {
		if (entityManager == null)
			throw new IllegalStateException("Erro");
		return entityManager;
	}

	@SuppressWarnings("unchecked")
	public DaoGenericoImpl() {
		this.oClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public T atualizar(T object) {
		getEntityManager().merge(object);
		return object;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void apagar(T object) {
		object = getEntityManager().merge(object);
		getEntityManager().remove(object);
	}

	@Override
	public T buscarPorId(ID id) {
		return (T) getEntityManager().find(oClass, id);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public T salvar(T object) {
		getEntityManager().clear();
		getEntityManager().persist(object);
		return object;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listarTodos() {
		String queryS = "SELECT obj FROM " + oClass.getSimpleName() + " obj";
		Query query = getEntityManager().createQuery(queryS);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> listPesqParam(String query, Map<String, Object> params) {
		Query q = getEntityManager().createQuery(query);
		for (String chave : params.keySet()) {
			q.setParameter(chave, params.get(chave));

		}
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> listPesqParam(String query, Map<String, Object> params,
			int maximo, int atual) {
		Query q = getEntityManager().createQuery(query).setMaxResults(maximo)
				.setFirstResult(atual);

		for (String chave : params.keySet()) {
			q.setParameter(chave, params.get(chave));

		}
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> listPesq(String query) {
		Query q = getEntityManager().createQuery(query);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public T pesqParam(String query, Map<String, Object> params) {
		Query q = getEntityManager().createQuery(query);
		for (String chave : params.keySet()) {
			q.setParameter(chave, params.get(chave));

		}
		try {
			return (T) q.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

}
