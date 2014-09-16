package br.com.sac.dto;

import java.io.Serializable;

public class EventoFiltroDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String nomeProfessor;
	private String ano;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

}
