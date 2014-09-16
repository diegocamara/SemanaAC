package br.com.sac.manager;

import br.com.sac.domain.UsuarioTipoEnum;
import br.com.sac.dto.UsuarioDTO;
import br.com.sac.dto.UsuarioLoginDTO;

public interface IUsuarioManager {

	/**
	 * Cadastra um usuário do tipo aluno.
	 * 
	 * @param usuarioDTO
	 * @param tipo
	 */
	void cadastrarUsuario(UsuarioDTO usuarioDTO, UsuarioTipoEnum tipo);

	/**
	 * Válida um cadastro de usuário
	 * 
	 * @param usuarioDTO
	 */
	boolean isUsuarioValido(UsuarioDTO usuarioDTO);

	/**
	 * Verifica se o email passado como argumento já existe.
	 * 
	 * @param email
	 * @return
	 */
	boolean isExisteEmailCadastrado(String email);

	/**
	 * Busca uma senha para um email cadastrado.
	 * 
	 * @param email
	 * @return
	 */
	String buscarSenhaUsuarioLogin(String email);

	/**
	 * Valida um login de usuário.
	 * 
	 * @param email
	 * @param senha
	 * @return
	 */
	boolean executarLogin(String email, String senha);

	/**
	 * Busca um usuário com login válido.
	 * 
	 * @param email
	 * @return
	 */
	UsuarioLoginDTO buscarUsuarioLogin(String email);
}
