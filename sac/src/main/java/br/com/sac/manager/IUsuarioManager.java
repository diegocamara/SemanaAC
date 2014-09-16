package br.com.sac.manager;

import br.com.sac.domain.UsuarioTipoEnum;
import br.com.sac.dto.UsuarioDTO;
import br.com.sac.dto.UsuarioLoginDTO;

public interface IUsuarioManager {

	/**
	 * Cadastra um usu�rio do tipo aluno.
	 * 
	 * @param usuarioDTO
	 * @param tipo
	 */
	void cadastrarUsuario(UsuarioDTO usuarioDTO, UsuarioTipoEnum tipo);

	/**
	 * V�lida um cadastro de usu�rio
	 * 
	 * @param usuarioDTO
	 */
	boolean isUsuarioValido(UsuarioDTO usuarioDTO);

	/**
	 * Verifica se o email passado como argumento j� existe.
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
	 * Valida um login de usu�rio.
	 * 
	 * @param email
	 * @param senha
	 * @return
	 */
	boolean executarLogin(String email, String senha);

	/**
	 * Busca um usu�rio com login v�lido.
	 * 
	 * @param email
	 * @return
	 */
	UsuarioLoginDTO buscarUsuarioLogin(String email);
}
