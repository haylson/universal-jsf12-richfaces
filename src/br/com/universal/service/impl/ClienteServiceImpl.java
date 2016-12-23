package br.com.universal.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.universal.dao.inter.IClienteDao;
import br.com.universal.model.Cliente;
import br.com.universal.service.inter.IClienteService;

@Transactional(readOnly = true)
public class ClienteServiceImpl implements IClienteService {
	
	private IClienteDao clienteDao;
	
	public void setClienteDao(IClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

	@Override
	@Transactional(readOnly = false)
	public Cliente salvar(Cliente cliente) {
		return clienteDao.salvar(cliente);
	}

	@Override
	@Transactional(readOnly = false)
	public void apagar(Cliente cliente) {
		clienteDao.apagar(cliente);
	}

	@Override
	@Transactional(readOnly = false)
	public Cliente atualizar(Cliente cliente) {
		return clienteDao.atualizar(cliente);
	}

	@Override
	public Cliente buscarPorId(Long id) {
		return clienteDao.buscarPorId(id);
	}
	
	@Override
	public List<Cliente> listarTodos() {
		return clienteDao.listarTodos();
	}

	@Override
	public List<Cliente> buscar(String opcaoBusca, String valor) {
		return clienteDao.buscar(opcaoBusca, valor);
	}

}