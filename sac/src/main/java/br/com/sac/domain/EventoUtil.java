package br.com.sac.domain;

public class EventoUtil {

	public static Evento criar( String nome, String nomeProfessor,
			String descricao, String ano) {
		Evento evento = new Evento();
		evento.setNome(nome);
		evento.setNomeProfessor(nomeProfessor);
		evento.setDescricao(descricao);
		evento.setAno(ano);
		return evento;
	}

}
