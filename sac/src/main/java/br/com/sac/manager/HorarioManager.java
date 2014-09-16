package br.com.sac.manager;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sac.dao.HorarioDAO;
import br.com.sac.domain.Horario;
import br.com.sac.dto.HorarioDTO;
import br.com.sac.util.ConstantesMensagens;
import br.com.sac.util.SacSystemUtil;

@Service
public class HorarioManager implements IHorarioManager {

	@Autowired
	private HorarioDAO horarioDAO;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void inserirHorarios(List<Horario> horarios) {
		horarioDAO.saveAll(horarios);
	}

	@Override
	@Transactional(readOnly = true)
	public List<HorarioDTO> consultarHorarios(int eventoId) {
		List<Horario> horarios = horarioDAO.consultarHorarios(eventoId);
		return obterListaHorarioDTO(horarios);
	}

	private List<HorarioDTO> obterListaHorarioDTO(List<Horario> horarios) {
		List<HorarioDTO> horariosDTO = new ArrayList<HorarioDTO>();

		for (Horario horario : horarios) {
			horariosDTO.add(obterHorarioDTO(horario));
		}

		return horariosDTO;
	}

	private HorarioDTO obterHorarioDTO(Horario horario) {
		HorarioDTO horarioDTO = new HorarioDTO();
		horarioDTO.setId(horario.getId());
		horarioDTO.setDiaSemana(horario.getDiaSemana());
		horarioDTO.setHoraInicio(horario.getHoraInicio().toDate());
		horarioDTO.setHoraFim(horario.getHoraFim().toDate());
		return horarioDTO;
	}

	public boolean isTodosHorariosValidos(List<Horario> horarios) {

		for (Horario horario : horarios) {

			if (isNotHorarioValido(horario)) {
				return false;
			}

		}

		return true;

	}

	private boolean isNotHorarioValido(Horario horario) {

		List<FacesMessage> mensagens = new ArrayList<FacesMessage>();

		if (isNotHorarioPreenchido(horario)) {
			mensagens
					.add(SacSystemUtil
							.obterFacesMessageErro(ConstantesMensagens.MSG_ERRO_UM_OU_MAIS_CAMPOS_HORARIO_NAO_PREENCHIDOS));
		} else if (isNotIntervaloValido(horario)) {
			mensagens
					.add(SacSystemUtil
							.obterFacesMessageErro(ConstantesMensagens.MSG_ERRO_INTERVALO_HORARIO_INVALIDO));
		} else if (isNotDiaValido(horario)) {
			mensagens
					.add(SacSystemUtil
							.obterFacesMessageErro(ConstantesMensagens.MSG_ERRO_DIA_HORARIO_INVALIDO));
		}

		if (mensagens.size() <= 0) {
			return false;
		} else {
			SacSystemUtil.adicionarMensagensErro(mensagens);
			return true;
		}

	}

	private boolean isNotHorarioPreenchido(Horario horario) {
		return SacSystemUtil.isNull(horario.getDiaSemana())
				&& SacSystemUtil.isNull(horario.getHoraInicio())
				&& SacSystemUtil.isNull(horario.getHoraFim());
	}

	private boolean isNotIntervaloValido(Horario horario) {
		return !isIntervaloValido(horario);
	}

	private boolean isIntervaloValido(Horario horario) {
		return SacSystemUtil.isNotNull(horario.getHoraInicio())
				&& SacSystemUtil.isNotNull(horario.getHoraFim())
				&& horario.getHoraInicio().isBefore(horario.getHoraFim());
	}

	private boolean isNotDiaValido(Horario horario) {
		LocalDateTime now = LocalDateTime.now();
		return horario.getDiaSemana().isBefore(now)
				|| horario.getDiaSemana().isEqual(now);
	}

	@Override
	public List<Horario> obterHorarios(List<HorarioDTO> horariosDTO) {
		List<Horario> horarios = new ArrayList<Horario>();
		for (HorarioDTO horarioDTO : horariosDTO) {
			horarios.add(obterHorario(horarioDTO));
		}
		return horarios;
	}

	private Horario obterHorario(HorarioDTO horarioDTO) {
		Horario horario = new Horario();
		horario.setDiaSemana(horarioDTO.getDiaSemana());
		horario.setHoraInicio(horarioDTO.getHoraInicio() == null ? null
				: LocalDateTime.fromDateFields(horarioDTO.getHoraInicio()));
		horario.setHoraFim(horarioDTO.getHoraFim() == null ? null
				: LocalDateTime.fromDateFields(horarioDTO.getHoraFim()));
		return horario;
	}

	public HorarioDAO getHorarioDAO() {
		return horarioDAO;
	}

	public void setHorarioDAO(HorarioDAO horarioDAO) {
		this.horarioDAO = horarioDAO;
	}

}
