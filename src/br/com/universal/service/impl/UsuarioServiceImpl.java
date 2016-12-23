package br.com.universal.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.universal.dao.inter.IUsuarioDao;
import br.com.universal.model.Usuario;
import br.com.universal.service.inter.IUsuarioService;

//@Component("usuarioService")
@Transactional(readOnly = true)
public class UsuarioServiceImpl implements IUsuarioService  {
	
	private IUsuarioDao usuarioDao;
	
	public void setUsuarioDao(IUsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public Usuario findByLoginSenha(String login, String senha) {
		return usuarioDao.findByLoginSenha(login, senha);
	}
	
	public Usuario findByLogin(String login) {
		return usuarioDao.findByLogin(login);
	}

	@Override
	public Usuario salvar(Usuario usuario) {
		return usuarioDao.salvar(usuario);
	}

	@Override
	public void apagar(Usuario usuario) {
		usuarioDao.apagar(usuario);
	}

	@Override
	public Usuario atualizar(Usuario usuario) {
		return usuarioDao.atualizar(usuario);
	}

	@Override
	public Usuario buscarPorId(Long id) {
		return usuarioDao.buscarPorId(id);
	}

	@Override
	public List<Usuario> listarTodas() {
		return usuarioDao.listarTodas();
	}

}