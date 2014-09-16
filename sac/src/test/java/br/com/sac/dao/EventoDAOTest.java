package br.com.sac.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.sac.domain.Evento;
import br.com.sac.domain.EventoUtil;
import br.com.sac.dto.EventoDTO;
import br.com.sac.dto.EventoFiltroDTO;

public class EventoDAOTest extends AbstractDAOTest {

	@Autowired
	private EventoDAO eventoDAO;

	@Test
	public void verificarConsultarEventos() {

		Evento evento1 = EventoUtil.criar("Evento 1", "Professor 1",
				"Descrição 1", "2014");
		Evento evento2 = EventoUtil.criar("Evento 2", "Professor 2",
				"Descrição 2", "2014");
		Evento evento3 = EventoUtil.criar("Evento 3", "Professor 3",
				"Descrição 3", "2014");
		Evento evento4 = EventoUtil.criar("Evento 4", "Professor 4",
				"Descrição 4", "2015");
		Evento evento5 = EventoUtil.criar("Evento 5", "Professor 5",
				"Descrição 5", "2015");

		save(evento1, evento2, evento3, evento4, evento5);

		
		EventoFiltroDTO eventoFiltroDTO = new EventoFiltroDTO();		
		
		List<EventoDTO> eventos = eventoDAO.consultarEventos(eventoFiltroDTO);
		
		Assert.assertEquals(5, eventos.size());
		
	}
	
	@Test
	public void verificarConsultarEventosComNome() {

		Evento evento1 = EventoUtil.criar("Evento 1", "Professor 1",
				"Descrição 1", "2014");
		Evento evento2 = EventoUtil.criar("Evento 2", "Professor 2",
				"Descrição 2", "2014");
		Evento evento3 = EventoUtil.criar("Evento 3", "Professor 3",
				"Descrição 3", "2014");
		Evento evento4 = EventoUtil.criar("Evento 4", "Professor 4",
				"Descrição 4", "2015");
		Evento evento5 = EventoUtil.criar("Evento 5", "Professor 5",
				"Descrição 5", "2015");

		save(evento1, evento2, evento3, evento4, evento5);

		
		EventoFiltroDTO eventoFiltroDTO = new EventoFiltroDTO();
		eventoFiltroDTO.setNome(evento3.getNome());
		
		List<EventoDTO> eventos = eventoDAO.consultarEventos(eventoFiltroDTO);
		
		Assert.assertEquals(1, eventos.size());
		Assert.assertEquals(evento3.getNome(), eventos.get(0).getNome());
		
	}
	
	@Test
	public void verificarConsultarEventosComNomeProfessor() {

		Evento evento1 = EventoUtil.criar("Evento 1", "Professor 1",
				"Descrição 1", "2014");
		Evento evento2 = EventoUtil.criar("Evento 2", "Professor 2",
				"Descrição 2", "2014");
		Evento evento3 = EventoUtil.criar("Evento 3", "Professor 3",
				"Descrição 3", "2014");
		Evento evento4 = EventoUtil.criar("Evento 4", "Professor 4",
				"Descrição 4", "2015");
		Evento evento5 = EventoUtil.criar("Evento 5", "Professor 5",
				"Descrição 5", "2015");

		save(evento1, evento2, evento3, evento4, evento5);

		
		EventoFiltroDTO eventoFiltroDTO = new EventoFiltroDTO();
		eventoFiltroDTO.setNomeProfessor(evento5.getNomeProfessor());
		
		List<EventoDTO> eventos = eventoDAO.consultarEventos(eventoFiltroDTO);
		
		Assert.assertEquals(1, eventos.size());
		Assert.assertEquals(evento5.getNomeProfessor(), eventos.get(0).getNomeProfessor());
		
	}
	
	@Test
	public void verificarConsultarEventosComAno() {

		Evento evento1 = EventoUtil.criar("Evento 1", "Professor 1",
				"Descrição 1", "2014");
		Evento evento2 = EventoUtil.criar("Evento 2", "Professor 2",
				"Descrição 2", "2014");
		Evento evento3 = EventoUtil.criar("Evento 3", "Professor 3",
				"Descrição 3", "2014");
		Evento evento4 = EventoUtil.criar("Evento 4", "Professor 4",
				"Descrição 4", "2015");
		Evento evento5 = EventoUtil.criar("Evento 5", "Professor 5",
				"Descrição 5", "2015");

		save(evento1, evento2, evento3, evento4, evento5);

		
		EventoFiltroDTO eventoFiltroDTO = new EventoFiltroDTO();
		eventoFiltroDTO.setAno(evento5.getAno());
		
		List<EventoDTO> eventos = eventoDAO.consultarEventos(eventoFiltroDTO);
		
		Assert.assertEquals(2, eventos.size());		
		
	}
	
	@Test
	public void verificarConsultarEventosComNomeAno() {

		Evento evento1 = EventoUtil.criar("Evento 1", "Professor 1",
				"Descrição 1", "2014");
		Evento evento2 = EventoUtil.criar("Evento 2", "Professor 2",
				"Descrição 2", "2014");
		Evento evento3 = EventoUtil.criar("Evento 3", "Professor 3",
				"Descrição 3", "2014");
		Evento evento4 = EventoUtil.criar("Evento 4", "Professor 4",
				"Descrição 4", "2015");
		Evento evento5 = EventoUtil.criar("Evento 5", "Professor 5",
				"Descrição 5", "2015");

		save(evento1, evento2, evento3, evento4, evento5);

		
		EventoFiltroDTO eventoFiltroDTO = new EventoFiltroDTO();
		eventoFiltroDTO.setNome(evento5.getNome());
		eventoFiltroDTO.setAno(evento5.getAno());
		
		List<EventoDTO> eventos = eventoDAO.consultarEventos(eventoFiltroDTO);
		
		Assert.assertEquals(1, eventos.size());
		Assert.assertEquals(evento5.getNome(), eventos.get(0).getNome());
		
	}
	
	

}
