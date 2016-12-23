package br.com.universal.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import br.com.universal.dao.inter.InterfaceDao;
import br.com.universal.util.HibernateUtil;

public class HibernateDao<T> implements InterfaceDao<T> {
	
	private Class<T> classe;

	@Override
	public void atualizar(T bean) {
		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		session.update(bean);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public void excluir(T bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T getBean(Serializable codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> getBeans() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void salvar(T bean) {
		// TODO Auto-generated method stub
		
	}

}
