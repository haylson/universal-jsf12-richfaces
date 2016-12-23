package br.com.universal.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.universal.dao.inter.IPessoaDao;
import br.com.universal.model.Pessoa;
import br.com.universal.service.inter.IPessoaService;

@Transactional(readOnly = true)
public class PessoaServiceImpl implements IPessoaService {

	private IPessoaDao pessoaDao;
	
	public void setPessoaDao(IPessoaDao pessoaDao) {
		this.pessoaDao = pessoaDao;
	}

	@Override
	@Transactional(readOnly = false)
	public Pessoa salvar(Pessoa pessoa) {
		return pessoaDao.salvar(pessoa);
	}

	@Override
	@Transactional(readOnly = false)
	public void apagar(Pessoa pessoa) {
		pessoaDao.apagar(pessoa);
	}

	@Override
	@Transactional(readOnly = false)
	public Pessoa atualizar(Pessoa pessoa) {
		return pessoaDao.atualizar(pessoa);
	}

	@Override
	public Pessoa buscarPorId(Long id) {
		return pessoaDao.buscarPorId(id);
	}
	
	@Override
	public List<Pessoa> listarTodas() {
		return pessoaDao.listarTodas();
	}
	
}
