package br.com.sac.domain;

public enum SimNaoEnum {

	SIM("1", "Sim"), NAO("0", "Não");

	private String codigo;
	private String descricao;

	private SimNaoEnum(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

}
