package br.com.sac.dto;

import java.io.Serializable;

import br.com.sac.domain.UsuarioTipoEnum;

public class UsuarioLoginDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String nome;
	private UsuarioTipoEnum tipo;

	
	public boolean isAdministrador(){
		return UsuarioTipoEnum.ADMINISTRADOR.equals(tipo);
	}
	
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

	public UsuarioTipoEnum getTipo() {
		return tipo;
	}

	public void setTipo(UsuarioTipoEnum tipo) {
		this.tipo = tipo;
	}

}
