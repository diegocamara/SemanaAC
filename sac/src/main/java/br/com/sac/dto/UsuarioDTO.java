package br.com.sac.dto;

import java.io.Serializable;

import org.joda.time.LocalDateTime;

import br.com.sac.util.SacSystemUtil;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String nome;
	private String cpf;
	private String email;
	private String emailRepetido;
	private String senha;
	private String senhaRepetida;
	private String curso;
	private LocalDateTime dataNascimento;
	private String tipo;

	public String getDescricaoDataNascimento() {
		return SacSystemUtil.obterDescricaoLocalDateTime(dataNascimento);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailRepetido() {
		return emailRepetido;
	}

	public void setEmailRepetido(String emailRepetido) {
		this.emailRepetido = emailRepetido;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenhaRepetida() {
		return senhaRepetida;
	}

	public void setSenhaRepetida(String senhaRepetida) {
		this.senhaRepetida = senhaRepetida;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
