package br.com.universal.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.universal.dao.inter.ICidadeDao;
import br.com.universal.model.Cidade;
import br.com.universal.service.inter.ICidadeService;

//@Component("cidadeService")
@Transactional(readOnly = true)
public class CidadeServiceImpl implements ICidadeService {
	
	private ICidadeDao cidadeDao;
	
	public void setCidadeDao(ICidadeDao cidadeDao) {
		this.cidadeDao = cidadeDao;
	}

	@Override
	@Transactional(readOnly = false)
	public Cidade salvar(Cidade cidade) {
		return cidadeDao.salvar(cidade);
	}

	@Override
	@Transactional(readOnly = false)
	public void apagar(Cidade cidade) {
		cidadeDao.apagar(cidade);
	}

	@Override
	public Cidade atualizar(Cidade cidade) {
		return cidadeDao.atualizar(cidade);
	}

	@Override
	public Cidade buscarPorId(Long id) {
		return cidadeDao.buscarPorId(id);
	}

	@Override
	public List<Cidade> listarTodas() {
		return cidadeDao.listarTodas();
	}
	
	@Override
	public List<Cidade> buscar(String opcaoBusca, String valor) {
		return cidadeDao.buscar(opcaoBusca, valor);
	}
	
	public List<Cidade> findByEstadoId(Long id){
		return cidadeDao.findByEstadoId(id);
	}

}
