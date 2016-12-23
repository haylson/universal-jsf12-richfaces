/**
 * 
 */
package br.com.universal.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import br.com.universal.dao.inter.ICidadeDao;
import br.com.universal.model.Cidade;

public class CidadeDaoImpl implements ICidadeDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Cidade salvar(Cidade cidade) {
		entityManager.persist(cidade);
		return cidade;
	}
	
	@Override
	public void apagar(Cidade cidade) {
		cidade = buscarPorId(cidade.getId());
		entityManager.remove(cidade);
	}

	@Override
	public Cidade atualizar(Cidade cidade) {
		return entityManager.merge(cidade);
	}

	@Override
	public Cidade buscarPorId(Long id) {
		return entityManager.find(Cidade.class, id);
	}

	//TODO
	//HQL COM PROGRESSÃO
	@SuppressWarnings("unchecked")
	public List<Cidade> listarTodas() {
		return entityManager.createQuery("SELECT NEW Cidade(cid.id, cid.nome, est.id, est.nome) FROM Cidade cid " +
		"INNER JOIN cid.estado est ORDER BY cid.id").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cidade> buscar(String opcaoBusca, String valor) {
		Query query = entityManager.createQuery("FROM Cidade cid WHERE cid." + opcaoBusca + " = :valor" );
		query.setParameter("valor", valor);
		return query.getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Cidade> findByEstadoId(Long id){
		Session session = (Session) entityManager.getDelegate();
		Criteria criteria = session.createCriteria(Cidade.class);
		criteria.add(Expression.eq("estado.id", id));
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		criteria.addOrder(Order.asc("nome"));
		return criteria.list();
	}
	
}
