package br.com.sac.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "TBFREQUENCIA")
public class Frequencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private int id;

	@Enumerated(EnumType.STRING)
	@Column(name = "FALTA", columnDefinition = "char(1)")
	private SimNaoEnum falta;

	@Column(name = "JUSTIFICATIVA", columnDefinition = "varchar(2000)")
	private String justificativa;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SimNaoEnum getFalta() {
		return falta;
	}

	public void setFalta(SimNaoEnum falta) {
		this.falta = falta;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.id).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Frequencia) {
			final Frequencia frequencia = (Frequencia) obj;
			return new EqualsBuilder().append(this.id, frequencia.getId())
					.isEquals();
		} else {
			return false;
		}

	}	

}
