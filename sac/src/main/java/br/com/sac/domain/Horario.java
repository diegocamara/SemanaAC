package br.com.sac.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

@Entity
@Table(name = "TBHORARIO")
public class Horario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private int id;

	@Column(name = "DIASEMANA")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	private LocalDateTime diaSemana;

	@Column(name = "HORAINICIO")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	private LocalDateTime horaInicio;

	@Column(name = "HORAFIM")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	private LocalDateTime horaFim;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "EVENTOID", referencedColumnName = "CODIGO")
	private Evento evento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(LocalDateTime diaSemana) {
		this.diaSemana = diaSemana;
	}

	public LocalDateTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalDateTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalDateTime getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(LocalDateTime horaFim) {
		this.horaFim = horaFim;
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

		if (obj instanceof Horario) {
			final Horario horario = (Horario) obj;
			return new EqualsBuilder().append(this.id, horario.getId())
					.append(this.horaInicio, horario.getHoraInicio())
					.append(this.horaFim, horario.getHoraFim()).isEquals();
		} else {
			return false;
		}

	}

}
