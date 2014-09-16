package br.com.sac.manager;

import java.util.List;

import br.com.sac.domain.Horario;
import br.com.sac.dto.HorarioDTO;

public interface IHorarioManager {

	/**
	 * Salva uma lista de horarios válidos.
	 * 
	 * @param horarios
	 */
	void inserirHorarios(List<Horario> horarios);

	/**
	 * Obtém uma lista de horários.
	 * 
	 * @param horariosDTO
	 * @return
	 */
	List<Horario> obterHorarios(List<HorarioDTO> horariosDTO);

	/**
	 * Verifica se todos os horários de uma lista de horários estão válidos.
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
