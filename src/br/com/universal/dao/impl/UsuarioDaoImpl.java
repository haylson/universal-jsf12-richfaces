package br.com.universal.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.universal.dao.inter.IUsuarioDao;
import br.com.universal.model.Usuario;

public class UsuarioDaoImpl implements IUsuarioDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public Usuario findByLoginSenha(String login, String senha) {
		String sql = "From Usuario where login = :login and senha = :senha and ativo = 'TRUE'";
		Query query = entityManager.createQuery(sql);
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		return (Usuario)query.getSingleResult();
		//return  query.getResultList().size() > 0 ? (Usuario) query.getResultList().get(0) : null;
	}
	
	public Usuario findByLogin(String login) {
		
		String sql = "From Usuario where login = :login";
		Query query = entityManager.createQuery(sql);
		query.setParameter("login", login);
		return  query.getResultList().size() > 0 ? (Usuario) query.getResultList().get(0) : null;
	}

	@Override
	public Usuario salvar(Usuario usuario) {
		entityManager.persist(usuario);
		return usuario;
	}
	
	@Override
	public void apagar(Usuario usuario) {
		usuario = buscarPorId(usuario.getId());
		entityManager.remove(usuario);
	}

	@Override
	public Usuario atualizar(Usuario usuario) {
		return entityManager.merge(usuario);
	}

	@Override
	public Usuario buscarPorId(Long id) {
		return entityManager.find(Usuario.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listarTodas() {
		return entityManager.createQuery("FROM Usuario").getResultList();
	}

}