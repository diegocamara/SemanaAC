package br.com.sac.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

/**
 * @author Diego
 *
 */
/**
 * @author Diego
 *
 */
@Entity
@Table(name = "TBUSUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private int id;

	@Column(name = "NOME", columnDefinition = "varchar(100)")
	private String nome;

	@Column(name = "CPF", columnDefinition = "char(14)")
	private String cpf;

	@Column(name = "EMAIL", columnDefinition = "varchar(50)")
	private String email;

	@Column(name = "SENHA", columnDefinition = "varchar(50)")
	private String senha;

	@Column(name = "CURSO", columnDefinition = "varchar(50)")
	private String curso;

	@Column(name = "DATANASCIMENTO")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	private LocalDateTime dataNascimento;

	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO")
	private UsuarioTipoEnum tipo;

	@OneToMany
	@JoinColumn(name = "USUARIOID")
	private List<Evento> eventos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public UsuarioTipoEnum getTipo() {
		return tipo;
	}

	public void setTipo(UsuarioTipoEnum tipo) {
		this.tipo = tipo;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.id).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Usuario) {
			final Usuario usuario = (Usuario) obj;
			return new EqualsBuilder().append(this.id, usuario.getId())
					.isEquals();
		} else {
			return false;
		}

	}

}
