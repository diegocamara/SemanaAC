package br.com.sac.domain;

public enum DiaSemanaEnum {

	SEGUNDA("1", "Segunda-Feira"), TERCA("2", "Terça-Feira"), QUARTA("3",
			"Quarta-Feira"), QUINTA("4", "Quinta-Feira"), SEXTA("5",
			"Quinta-Feira"), SABADO("6", "Sábado"), DOMINGO("7", "Domingo");

	private String codigo;
	private String descricao;
	
	private DiaSemanaEnum(String codigo, String descricao){
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
}
