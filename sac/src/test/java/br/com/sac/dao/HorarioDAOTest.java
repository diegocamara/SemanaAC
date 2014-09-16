package br.com.sac.dao;

import java.util.List;

import org.joda.time.LocalDateTime;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.sac.domain.Evento;
import br.com.sac.domain.EventoUtil;
import br.com.sac.domain.Horario;
import br.com.sac.domain.HorarioUtil;

public class HorarioDAOTest extends AbstractDAOTest {

	@Autowired
	private HorarioDAO horarioDAO;

	@Test
	public void verificarConsultarHorarios() {

		Evento evento1 = EventoUtil.criar("Evento 1", "Professor 1",
				"Descrição 1", "2014");
		Evento evento2 = EventoUtil.criar("Evento 2", "Professor 2",
				"Descrição 2", "2014");

		save(evento1, evento2);

		Horario horario1 = HorarioUtil.criar(LocalDateTime.parse("2014-09-20"),
				LocalDateTime.parse("2014-09-20"),
				LocalDateTime.parse("2014-09-20"), evento1);
		Horario horario2 = HorarioUtil.criar(LocalDateTime.parse("2014-09-20"),
				LocalDateTime.parse("2014-09-20"),
				LocalDateTime.parse("2014-09-20"), evento1);
		Horario horario3 = HorarioUtil.criar(LocalDateTime.parse("2014-09-20"),
				LocalDateTime.parse("2014-09-20"),
				LocalDateTime.parse("2014-09-20"), evento2);
		Horario horario4 = HorarioUtil.criar(LocalDateTime.parse("2014-09-20"),
				LocalDateTime.parse("2014-09-20"),
				LocalDateTime.parse("2014-09-20"), evento2);
		Horario horario5 = HorarioUtil.criar(LocalDateTime.parse("2014-09-20"),
				LocalDateTime.parse("2014-09-20"),
				LocalDateTime.parse("2014-09-20"), evento2);

		save(horario1, horario2, horario3, horario4, horario5);

		List<Horario> horarios = horarioDAO.consultarHorarios(evento2.getId());

		Assert.assertEquals(3, horarios.size());
		Assert.assertEquals(evento2, horarios.get(0).getEvento());

	}

}
