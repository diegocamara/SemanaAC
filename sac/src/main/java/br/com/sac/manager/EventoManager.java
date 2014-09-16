package br.com.sac.manager;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sac.dao.EventoDAO;
import br.com.sac.domain.Evento;
import br.com.sac.domain.Horario;
import br.com.sac.dto.EventoDTO;
import br.com.sac.dto.EventoFiltroDTO;
import br.com.sac.dto.HorarioDTO;
import br.com.sac.util.ConstantesMensagens;
import br.com.sac.util.SacSystemUtil;

@Service
public class EventoManager implements IEventoManager {

	@Autowired
	private IHorarioManager horarioManager;

	@Autowired
	private EventoDAO eventoDAO;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void inserirEvento(EventoDTO eventoDTO, List<Horario> horarios) {
		Evento evento = obterEvento(eventoDTO);
		eventoDAO.save(evento);
		configurarInserirHorarios(horarios, evento);
	}

	@Override
	@Transactional(readOnly = true)
	public List<EventoDTO> consultarEventos(EventoFiltroDTO eventoFiltroDTO) {

		List<EventoDTO> eventos = eventoDAO.consultarEventos(eventoFiltroDTO);

		for (EventoDTO eventoDTO : eventos) {
			List<HorarioDTO> horarios = horarioManager
					.consultarHorarios(eventoDTO.getId());
			eventoDTO.setHorarios(horarios);
		}

		return eventos;
	}

	@Override
	public boolean isEventoValido(EventoDTO eventoDTO, List<Horario> horarios) {
		return isCamposEventoValidos(eventoDTO)
				&& horarioManager.isTodosHorariosValidos(horarios);
	}

	private void configurarInserirHorarios(List<Horario> horarios, Evento evento) {
		for (Horario horario : horarios) {
			horario.setEvento(evento);
		}
		horarioManager.inserirHorarios(horarios);
	}

	private boolean isCamposEventoValidos(EventoDTO eventoDTO) {
		if (StringUtils.isNotBlank(eventoDTO.getNome())
				&& StringUtils.isNotBlank(eventoDTO.getNomeProfessor())
				&& StringUtils.isNotBlank(eventoDTO.getDescricao())
				&& StringUtils.isNotBlank(eventoDTO.getAno())) {
			return true;
		} else {
			SacSystemUtil
					.adicionarMensagemErro(ConstantesMensagens.MSG_ERRO_AO_SALVAR_EVENTO_UM_OU_MAIS_CAMPOS_NAO_PREENCHIDOS);
			return false;
		}

	}

	private Evento obterEvento(EventoDTO eventoDTO) {
		Evento evento = new Evento();
		evento.setNumeroVagas(eventoDTO.getNumeroVagas());
		evento.setNome(eventoDTO.getNome());
		evento.setNomeProfessor(eventoDTO.getNomeProfessor());
		evento.setDescricao(eventoDTO.getDescricao());
		evento.setAno(eventoDTO.getAno());
		return evento;
	}

	public IHorarioManager getHorarioManager() {
		return horarioManager;
	}

	public void setHorarioManager(IHorarioManager horarioManager) {
		this.horarioManager = horarioManager;
	}

	public EventoDAO getEventoDAO() {
		return eventoDAO;
	}

	public void setEventoDAO(EventoDAO eventoDAO) {
		this.eventoDAO = eventoDAO;
	}

}
