package br.com.universal.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.universal.dao.inter.IClienteDao;
import br.com.universal.model.Cliente;

public class ClienteDaoImpl implements IClienteDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Cliente salvar(Cliente cliente) {
		entityManager.persist(cliente.getPessoa());
		entityManager.persist(cliente);
		return cliente;
	}
	
	@Override
	public void apagar(Cliente cliente) {
		cliente = buscarPorId(cliente.getId());
		entityManager.remove(cliente);
		entityManager.remove(cliente.getPessoa());
	}

	@Override
	public Cliente atualizar(Cliente cliente) {
		entityManager.merge(cliente.getPessoa());
		entityManager.merge(cliente);
		return cliente;
	}

	@Override
	public Cliente buscarPorId(Long id) {
		return entityManager.find(Cliente.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> buscar(String opcaoBusca, String valor) {
		Query query = entityManager.createQuery("SELECT cli FROM Cliente cli " +
        "INNER JOIN FETCH cli.pessoa pes WHERE lower(pes." + opcaoBusca + ") like lower(:valor)" );
		query.setParameter("valor", "%"+valor+"%");
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked") //Despreza o warning
	public List<Cliente> listarTodos(){
		return entityManager.createQuery("FROM Cliente ORDER BY id").getResultList();
	}
	
//TODO	
//	Obs: No caso da Navegação do DataTable onde não se conseguia buscar os dados
//	de Pessoa (que é atributo de cliente, e FK no BD) e estourava erro na paginação
//	com os atributos de Pessoa, pois ele por estar LAZY deixa aberta a transação apenas 
//	de cliente. Solucionamos fazendo um INNER JOIN no código HQL como mostrado abaixo, ou
//	modificando para o tipo EAGER, a melhor solucão vai depender do caso. Deixando aqui
//	como registro pra consultas posteriores.
//	
//	@SuppressWarnings("unchecked")
//	public List<Cliente> listarTodos(){
//		return entityManager.createQuery("SELECT cli FROM Cliente cli " +
//				                         "INNER JOIN FETCH cli.pessoa pes")
//		                    .getResultList();
//	}
	
}
