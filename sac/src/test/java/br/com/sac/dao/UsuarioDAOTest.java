package br.com.sac.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.sac.domain.Usuario;
import br.com.sac.domain.UsuarioTipoEnum;
import br.com.sac.domain.UsuarioUtil;
import br.com.sac.dto.UsuarioLoginDTO;

public class UsuarioDAOTest extends AbstractDAOTest {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Test
	public void verificarExisteEmailCadastrado() {

		Usuario usuario1 = UsuarioUtil.criar("usuario 1", "123",
				"usuario1@sac.com.br", "curso", "123");
		Usuario usuario2 = UsuarioUtil.criar("usuario 2", "123",
				"usuario2@sac.com.br", "curso", "123");
		Usuario usuario3 = UsuarioUtil.criar("usuario 3", "123",
				"usuario3@sac.com.br", "curso", "123");

		save(usuario1, usuario2, usuario3);

		boolean existeEmailCadastrado = usuarioDAO
				.isExisteEmailCadastrado(usuario1.getEmail());

		Assert.assertTrue(existeEmailCadastrado);

	}

	@Test
	public void verificarBuscarUsuarioLoginComEmailExistente() {

		Usuario usuario1 = UsuarioUtil.criar("usuario 1", "123",
				"usuario1@sac.com.br", "curso", "senhaTest7");
		Usuario usuario2 = UsuarioUtil.criar("usuario 2", "123",
				"usuario2@sac.com.br", "curso", "senhaTest8");
		Usuario usuario3 = UsuarioUtil.criar("usuario 3", "123",
				"usuario3@sac.com.br", "curso", "senhaTest9");

		save(usuario1, usuario2, usuario3);

		String senhaUsuario = this.usuarioDAO.buscarSenhaUsuarioLogin(usuario2
				.getEmail());

		Assert.assertEquals(usuario2.getSenha(), senhaUsuario);

	}

	@Test
	public void verificarBuscarUsuarioLoginSemEmailExistente() {

		Usuario usuario1 = UsuarioUtil.criar("usuario 1", "123",
				"usuario1@sac.com.br", "curso", "senhaTest7");
		Usuario usuario2 = UsuarioUtil.criar("usuario 2", "123",
				"usuario2@sac.com.br", "curso", "senhaTest8");
		Usuario usuario3 = UsuarioUtil.criar("usuario 3", "123",
				"usuario3@sac.com.br", "curso", "senhaTest9");
		Usuario usuario4 = UsuarioUtil.criar("usuario 3", "123",
				"usuario4@sac.com.br", "curso", "senhaTest9");

		save(usuario1, usuario2, usuario3);

		String senhaUsuario = this.usuarioDAO.buscarSenhaUsuarioLogin(usuario4
				.getEmail());

		Assert.assertNull(senhaUsuario);

	}

	@Test
	public void verificarBuscarUsuarioLogin() {
		Usuario usuario1 = UsuarioUtil.criar("usuario 1", "123",
				"usuario1@sac.com.br", "curso", "senhaTest7", UsuarioTipoEnum.ALUNO);
		Usuario usuario2 = UsuarioUtil.criar("usuario 2", "123",
				"usuario2@sac.com.br", "curso", "senhaTest8",UsuarioTipoEnum.ALUNO);
		Usuario usuario3 = UsuarioUtil.criar("usuario 3", "123",
				"usuario3@sac.com.br", "curso", "senhaTest9",UsuarioTipoEnum.ALUNO);
		Usuario usuario4 = UsuarioUtil.criar("usuario 4", "123",
				"usuario4@sac.com.br", "curso", "senhaTest10",UsuarioTipoEnum.ALUNO);

		save(usuario1, usuario2, usuario3, usuario4);

		UsuarioLoginDTO usuarioLoginDTO = this.usuarioDAO
				.buscarUsuarioLogin(usuario3.getEmail());
		
		Assert.assertNotNull(usuarioLoginDTO);
		
		Assert.assertEquals(usuario3.getId(), usuarioLoginDTO.getId());
		
	}

}
