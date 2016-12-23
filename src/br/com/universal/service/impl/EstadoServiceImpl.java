package br.com.universal.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.universal.dao.inter.IEstadoDao;
import br.com.universal.model.Estado;
import br.com.universal.service.inter.IEstadoService;

//@Component("estadoService")
@Transactional(readOnly = true)
public class EstadoServiceImpl implements IEstadoService {
	
	private IEstadoDao estadoDao;
	
	public void setEstadoDao(IEstadoDao estadoDao) {
		this.estadoDao = estadoDao;
	}
	
	@Override
	@Transactional(readOnly = false)
	public Estado salvar(Estado estado) {
		return estadoDao.salvar(estado);
	}

	@Override
	@Transactional(readOnly = false)
	public void apagar(Estado estado) {
		estadoDao.apagar(estado);
	}

	@Override
	@Transactional(readOnly = false)
	public Estado atualizar(Estado estado) {
		return estadoDao.atualizar(estado);
	}

	@Override
	public Estado buscarPorId(Long id) {
		return estadoDao.buscarPorId(id);
	}

	@Override
	public List<Estado> listarTodos() {
		return estadoDao.listarTodos();
	}

	@Override
	public List<Estado> buscar(String opcaoBusca, String valor) {
		return estadoDao.buscar(opcaoBusca, valor);
	}

}
