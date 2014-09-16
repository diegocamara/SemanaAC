package br.com.sac.manager;

import java.util.List;

import br.com.sac.domain.Horario;
import br.com.sac.dto.HorarioDTO;

public interface IHorarioManager {

	/**
	 * Salva uma lista de horarios v�lidos.
	 * 
	 * @param horarios
	 */
	void inserirHorarios(List<Horario> horarios);

	/**
	 * Obt�m uma lista de hor�rios.
	 * 
	 * @param horariosDTO
	 * @return
	 */
	List<Horario> obterHorarios(List<HorarioDTO> horariosDTO);

	/**
	 * Verifica se todos os hor�rios de uma lista de hor�rios est�o v�lidos.
	 * 
	 * @param horarios
	 * @return
	 */
	boolean isTodosHorariosValidos(List<Horario> horarios);

	/**
	 * Consulta uma lista de horarios relacionados com um evento especifico.
	 * 
	 * @param eventoId
	 * @return
	 */
	List<HorarioDTO> consultarHorarios(int eventoId);
}
