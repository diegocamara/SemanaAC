package br.com.sac.manager;

import java.util.List;

import br.com.sac.domain.Horario;
import br.com.sac.dto.EventoDTO;
import br.com.sac.dto.EventoFiltroDTO;

public interface IEventoManager {

	void inserirEvento(EventoDTO eventoDTO, List<Horario> horarios);
	
	boolean isEventoValido(EventoDTO eventoDTO, List<Horario> horarios);
	
	List<EventoDTO> consultarEventos(EventoFiltroDTO eventoFiltroDTO);
	
}
