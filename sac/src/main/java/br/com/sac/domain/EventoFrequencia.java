package br.com.sac.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "TBEVENTOFREQUENCIA")
public class EventoFrequencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private int id;

	@OneToOne
	@JoinColumn(name = "EVENTO")
	private Evento evento;

	@OneToOne
	@JoinColumn(name = "USUARIO")
	private Usuario usuario;

	@OneToOne
	@JoinColumn(name = "FREQUENCIA")
	private Frequencia frequencia;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Frequencia getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(Frequencia frequencia) {
		this.frequencia = frequencia;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.id).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof EventoFrequencia) {
			final EventoFrequencia eventoFrequencia = (EventoFrequencia) obj;
			return new EqualsBuilder().append(this.id, eventoFrequencia.getId())
					.isEquals();
		} else {
			return false;
		}

	}	

}
