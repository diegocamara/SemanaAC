package br.com.sac.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDateTime;

public class SacSystemUtil {

	public static void adicionarMensagemOperacaoSucesso() {

		FacesMessage facesMessage = new FacesMessage(
				MensagensUtil.getMessage(ConstantesMensagens.SUCESSO),
				MensagensUtil
						.getMessage(ConstantesMensagens.OPERACAO_REALIZADA_COM_SUCESSO));

		FacesContext.getCurrentInstance().addMessage(null, facesMessage);

	}

	public static void adicionarMensagemErro(String mensagem) {
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_ERROR, StringUtils.EMPTY,
				MensagensUtil.getMessage(mensagem));
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	public static void adicionarMensagensErro(List<FacesMessage> mensagens) {
		for (FacesMessage facesMessage : mensagens) {
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}
	}

	public static FacesMessage obterFacesMessageErro(String constanteMessage) {
		return new FacesMessage(FacesMessage.SEVERITY_ERROR, StringUtils.EMPTY,
				MensagensUtil.getMessage(constanteMessage));
	}

	public static boolean isNull(Object object) {
		return object == null;
	}

	public static boolean isNotNull(Object object) {
		return !isNull(object);
	}

	public static String obterDescricaoLocalDateTime(LocalDateTime localDateTime) {

		String date = StringUtils.EMPTY;

		if (isNotNull(localDateTime)) {
			date = String.format("%s/%s/%s", localDateTime.getDayOfMonth(),
					localDateTime.getMonthOfYear(), localDateTime.getYear());
		}

		return date;
	}
	
	public static String obterDescricaoHora(Date date){
		
		String time = StringUtils.EMPTY;
		
		if(isNotNull(date)){
			time = new SimpleDateFormat("HH:mm").format(date);
		}
		return time;
	}

}
