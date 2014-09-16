package br.com.sac.domain;

import org.joda.time.LocalDateTime;

public class HorarioUtil {

	public static Horario criar(LocalDateTime diaSemana,
			LocalDateTime horaInicio, LocalDateTime horaFim, Evento evento) {
		Horario horario = new Horario();
		horario.setDiaSemana(diaSemana);
		horario.setHoraInicio(horaInicio);
		horario.setHoraFim(horaFim);
		horario.setEvento(evento);
		return horario;
	}

}
