package br.com.universal.dao.inter;

import java.util.List;

import br.com.universal.model.Usuario;

public interface IUsuarioDao {
	
	Usuario findByLoginSenha(String login, String senha);
	
	Usuario findByLogin(String login);
	
	Usuario salvar(Usuario usuario);
	
	Usuario buscarPorId(Long id);
	
	void apagar(Usuario usuario);
	
	Usuario atualizar(Usuario usuario);
	
	List<Usuario> listarTodas();

	
}