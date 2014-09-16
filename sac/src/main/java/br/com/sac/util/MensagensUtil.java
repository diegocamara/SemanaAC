package br.com.sac.util;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public class MensagensUtil {

	private static final String NAO_ENCOTRADA_NO_RESOURCE_BUNDLE = " não encotrada no ResourceBundle";
	private static final String CONSTANTE = "Constante ";
	private static final String STRING_VAZIA = "";
	private static final String BUNDLE_NAME = "messages";
	private static ResourceBundle bundle;

	public static ResourceBundle getBundle() {
		if (bundle == null) {
			FacesContext context = FacesContext.getCurrentInstance();
			bundle = context.getApplication()
					.getResourceBundle(context, BUNDLE_NAME);
		}
		return bundle;
	}
	
	public static String getMessage(String constantMessage){
		String message = STRING_VAZIA;
		try{
			message = getBundle().getString(constantMessage);
		}catch(MissingResourceException e){
			message = CONSTANTE + constantMessage + NAO_ENCOTRADA_NO_RESOURCE_BUNDLE;
		}
		return message;
	}
	
	public static String getMessage(String constantMessage, Object... params){
		String message = STRING_VAZIA;
		try{
			message = MessageFormat.format(getBundle().getString(constantMessage),params);
		}catch(MissingResourceException e){
			message = CONSTANTE + constantMessage + NAO_ENCOTRADA_NO_RESOURCE_BUNDLE;
		}
		return message;
	}
	
}
