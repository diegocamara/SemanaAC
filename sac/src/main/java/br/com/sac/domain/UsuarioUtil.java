package br.com.sac.domain;

public class UsuarioUtil {

	public static Usuario criar(String nome, String cpf, String email, String curso, String senha){
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setCpf(cpf);
		usuario.setEmail(email);
		usuario.setCurso(curso);
		usuario.setSenha(senha);
		return usuario;
	}
	
	public static Usuario criar(String nome, String cpf, String email, String curso, String senha, UsuarioTipoEnum tipo){
		Usuario usuario = criar(nome, cpf, email, curso, senha);
		usuario.setTipo(tipo);
		return usuario;
	}
	
}
