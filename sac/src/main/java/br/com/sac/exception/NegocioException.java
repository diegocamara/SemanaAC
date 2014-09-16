package br.com.sac.exception;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;

import org.apache.commons.lang3.StringUtils;

import br.com.sac.util.MensagensUtil;

public class NegocioException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private List<FacesMessage> mensagens;

	public NegocioException() {
		this.mensagens = new ArrayList<FacesMessage>();
	}

	public NegocioException(String mensagem) {
		this();
		this.mensagens.add(new FacesMessage(StringUtils.EMPTY, MensagensUtil.getMessage(mensagem)));
	}

	public NegocioException(List<FacesMessage> mensagens) {
		this.mensagens = mensagens;
	}

	public List<FacesMessage> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<FacesMessage> mensagens) {
		this.mensagens = mensagens;
	}

}
