package br.com.universal.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.universal.dao.inter.IPromotorDao;
import br.com.universal.model.Promotor;

public class PromotorDaoImpl implements IPromotorDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Promotor salvar(Promotor promotor) {
		entityManager.persist(promotor.getPessoa());
		entityManager.persist(promotor);
		return promotor;
	}
	
	@Override
	public void apagar(Promotor promotor) {
		promotor = buscarPorId(promotor.getId());
		entityManager.remove(promotor);
		entityManager.remove(promotor.getPessoa());
	}

	@Override
	public Promotor atualizar(Promotor promotor) {
		entityManager.merge(promotor.getPessoa());
		entityManager.merge(promotor);
		return promotor;
	}

	@Override
	public Promotor buscarPorId(Long id) {
		return entityManager.find(Promotor.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Promotor> listarTodos() {
		return entityManager.createQuery("FROM Promotor ORDER BY id").getResultList();
	}

}
