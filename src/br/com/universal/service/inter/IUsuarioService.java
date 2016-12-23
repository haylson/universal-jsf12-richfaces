package br.com.universal.service.inter;

import java.util.List;

import br.com.universal.model.Usuario;

public interface IUsuarioService {
	
	Usuario findByLoginSenha(String login, String senha);
	
	Usuario findByLogin(String login);
	
	Usuario salvar(Usuario usuario);
	
	Usuario buscarPorId(Long id);
	
	void apagar(Usuario usuario);
	
	Usuario atualizar(Usuario usuario);
	
	List<Usuario> listarTodas();

}
