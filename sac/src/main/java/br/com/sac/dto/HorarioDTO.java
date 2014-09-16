package br.com.sac.dto;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.LocalDateTime;

import br.com.sac.domain.Evento;
import br.com.sac.util.ConstantesMensagens;
import br.com.sac.util.MensagensUtil;
import br.com.sac.util.SacSystemUtil;

public class HorarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private LocalDateTime diaSemana;
	private Date horaInicio;
	private Date horaFim;
	private Evento evento;

	public String getDescricaoDia() {
		return SacSystemUtil.obterDescricaoLocalDateTime(diaSemana);
	}

	public String getDescricaoHoraInicio() {
		return SacSystemUtil.obterDescricaoHora(horaInicio);
	}

	public String getDescricaoHoraFim() {
		return SacSystemUtil.obterDescricaoHora(horaFim);
	}

	public String getDescricaoConfirmacaoHorario() {
		return MensagensUtil.getMessage(
				ConstantesMensagens.MSG_CONFIRMAR_HORARIO, getDescricaoDia(),
				getDescricaoHoraInicio(), getDescricaoHoraFim());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(Date horaFim) {
		this.horaFim = horaFim;
	}

	public LocalDateTime getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(LocalDateTime diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.id).append(this.horaInicio)
				.append(this.horaFim).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof HorarioDTO) {
			final HorarioDTO horarioDTO = (HorarioDTO) obj;
			return new EqualsBuilder().append(this.id, horarioDTO.getId())
					.append(this.horaInicio, horarioDTO.getHoraInicio())
					.append(this.horaFim, horarioDTO.getHoraFim()).isEquals();
		} else {
			return false;
		}

	}

}
