package br.com.universal.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.universal.dao.inter.IEstadoDao;
import br.com.universal.model.Estado;

public class EstadoDaoImpl implements IEstadoDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Estado salvar(Estado estado) {
		entityManager.persist(estado);
		return estado;
	}

	@Override
	public void apagar(Estado estado) {
		estado = buscarPorId(estado.getId());
		entityManager.remove(estado);
	}

	@Override
	public Estado atualizar(Estado estado) {
		return entityManager.merge(estado);
	}

	@Override
	public Estado buscarPorId(Long id) {
		return entityManager.find(Estado.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Estado> listarTodos() {
		return entityManager.createQuery("FROM Estado ORDER BY nome")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estado> buscar(String opcaoBusca, String valor) {
		Query query = entityManager.createQuery("FROM Estado est WHERE est."
				+ opcaoBusca + " = :valor");
		query.setParameter("valor", valor);
		return query.getResultList();
	}

}