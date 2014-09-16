package br.com.sac.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class EventoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private Integer numeroVagas;
	private String nome;
	private String descricao;
	private String nomeProfessor;
	private String ano;
	private List<HorarioDTO> horarios;

	public EventoDTO() {
		setHorarios(new ArrayList<HorarioDTO>());
		getHorarios().add(new HorarioDTO());		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getNumeroVagas() {
		return numeroVagas;
	}

	public void setNumeroVagas(Integer numeroVagas) {
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

	public List<HorarioDTO> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<HorarioDTO> horarios) {
		this.horarios = horarios;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.id).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof EventoDTO) {
			final EventoDTO eventoDTO = (EventoDTO) obj;
			return new EqualsBuilder().append(this.id, eventoDTO.getId())
					.isEquals();
		} else {
			return false;
		}

	}

}
