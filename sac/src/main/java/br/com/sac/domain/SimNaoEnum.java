package br.com.sac.domain;

public enum SimNaoEnum {

	SIM("1", "Sim"), NAO("0", "N�o");

	private String codigo;
	private String descricao;

	private SimNaoEnum(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

}
