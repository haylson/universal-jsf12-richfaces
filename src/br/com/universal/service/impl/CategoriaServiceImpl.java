package br.com.universal.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.universal.dao.inter.ICategoriaDao;
import br.com.universal.model.Categoria;
import br.com.universal.service.inter.IDaoService;

@Transactional(readOnly = true)
public class CategoriaServiceImpl implements IDaoService<Categoria, Serializable>{

	private ICategoriaDao categoriaDao;
	
	@Override
	@Transactional(readOnly = false)
	public void apagar(Categoria categoria) {
		categoriaDao.apagar(categoria);
	}

	@Override
	@Transactional(readOnly = false)
	public Categoria atualizar(Categoria categoria) {
		return categoriaDao.atualizar(categoria);
	}

	@Override
	public Categoria buscarPorId(Serializable id) {
		return categoriaDao.buscarPorId(id);
	}

	@Override
	public Class<Categoria> getObjectClass() {
		return categoriaDao.getObjectClass();
	}

	@Override
	public List<Categoria> listarTodos() {
		return categoriaDao.listarTodos();
	}

	@Override
	@Transactional(readOnly = false)
	public Categoria salvar(Categoria categoria) {
		return categoriaDao.salvar(categoria);
	}

	public void setCategoriaDao(ICategoriaDao categoriaDao) {
		this.categoriaDao = categoriaDao;
	}

	public ICategoriaDao getCategoriaDao() {
		return categoriaDao;
	}

}
