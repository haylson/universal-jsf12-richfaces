package br.com.universal.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.universal.dao.inter.IPromotorDao;
import br.com.universal.model.Promotor;
import br.com.universal.service.inter.IPromotorService;

@Transactional(readOnly = true)
public class PromotorServiceImpl implements IPromotorService {
	
	private IPromotorDao promotorDao;
	
	public void setPromotorDao(IPromotorDao promotorDao) {
		this.promotorDao = promotorDao;
	}
	
	@Override
	@Transactional(readOnly = false)
	public Promotor salvar(Promotor promotor) {
		return promotorDao.salvar(promotor);
	}

	@Override
	@Transactional(readOnly = false)
	public void apagar(Promotor promotor) {
		promotorDao.apagar(promotor);
	}

	@Override
	@Transactional(readOnly = false)
	public Promotor atualizar(Promotor promotor) {
		return promotorDao.atualizar(promotor);
	}

	@Override
	public Promotor buscarPorId(Long id) {
		return promotorDao.buscarPorId(id);
	}

	@Override
	public List<Promotor> listarTodos() {
		return promotorDao.listarTodos();
	}

}
