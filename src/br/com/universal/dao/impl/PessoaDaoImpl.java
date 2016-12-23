package br.com.universal.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.universal.dao.inter.IPessoaDao;
import br.com.universal.model.Pessoa;

public class PessoaDaoImpl implements IPessoaDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Pessoa salvar(Pessoa pessoa) {
		entityManager.persist(pessoa);
		return pessoa;
	}
	
	@Override
	public void apagar(Pessoa pessoa) {
		pessoa = buscarPorId(pessoa.getId());
		entityManager.remove(pessoa);
	}

	@Override
	public Pessoa atualizar(Pessoa pessoa) {
		return entityManager.merge(pessoa);
	}

	@Override
	public Pessoa buscarPorId(Long id) {
		return entityManager.find(Pessoa.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> listarTodas(){
		return entityManager.createQuery("FROM Pessoa").getResultList();
	}
	
}
