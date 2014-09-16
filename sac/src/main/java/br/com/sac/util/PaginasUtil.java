package br.com.sac.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public class PaginasUtil {

	private static final String NAO_ENCOTRADA_NO_RESOURCE_BUNDLE = " não encotrada no ResourceBundle";
	private static final String CONSTANTE = "Constante ";
	private static final String STRING_VAZIA = "";
	private static final String BUNDLE_NAME = "paginas";
	private static ResourceBundle bundle;

	public static ResourceBundle getBundle(){
		if(bundle == null){
			FacesContext context = FacesContext.getCurrentInstance();
			bundle = context.getApplication().getResourceBundle(context, BUNDLE_NAME);
		}
		return bundle;
	}
	
	public static String getPage(String constantPage){
		String pageUrl = STRING_VAZIA;
		try{
			pageUrl = getBundle().getString(constantPage);
		}catch(MissingResourceException e){
			pageUrl = CONSTANTE + constantPage + NAO_ENCOTRADA_NO_RESOURCE_BUNDLE;
		}
		return pageUrl;
	}
	
	public static String getPageWithRedirect(String constantPage){
		String pageUrl = STRING_VAZIA;
		try{
			pageUrl = getBundle().getString(constantPage) + "?faces-redirect=true";
		}catch(MissingResourceException e){
			pageUrl = CONSTANTE + constantPage + NAO_ENCOTRADA_NO_RESOURCE_BUNDLE;
		}
		return pageUrl;
	}
	
}
