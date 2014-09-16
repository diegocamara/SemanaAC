package br.com.sac.domain;

public enum UsuarioTipoEnum {

	ALUNO("Aluno"), ADMINISTRADOR("Administrador");

	private String descricao;

	private UsuarioTipoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
