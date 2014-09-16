package br.com.sac.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "TBEVENTO")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private int id;

	@Column(name = "NUMEROVAGAS")
	private int numeroVagas;

	@Column(name = "NOME", columnDefinition = "varchar(2000)")
	private String nome;

	@Column(name = "DESCRICAO", columnDefinition = "varchar(2000)")
	private String descricao;

	@Column(name = "NOMEPROFESSOR", columnDefinition = "varchar(50)")
	private String nomeProfessor;

	@Column(name = "ANO", columnDefinition = "char(4)")
	private String ano;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroVagas() {
		return numeroVagas;
	}

	public void setNumeroVagas(int numeroVagas) {
		this.numeroVagas = numeroVagas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.id).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Evento) {
			final Evento evento = (Evento) obj;
			return new EqualsBuilder().append(this.id, evento.getId())
					.isEquals();
		} else {
			return false;
		}

	}

}
