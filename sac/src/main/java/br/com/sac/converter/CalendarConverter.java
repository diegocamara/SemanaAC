package br.com.sac.converter;

import java.text.SimpleDateFormat;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDateTime;

import br.com.sac.util.SacSystemUtil;

@FacesConverter(value = "calendarConverter")
public class CalendarConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {		
		
		if(StringUtils.isNotBlank(arg2)){
			
			String date[] = arg2.split("/");
			
			String formatedDate = date[2] + "-" + date[1] + "-" + date[0];
			
			return new LocalDateTime(formatedDate);
		}else{
			return null;
		}		
		
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		
		if(SacSystemUtil.isNotNull(arg2) && arg2 instanceof LocalDateTime){
			LocalDateTime localDateTime = (LocalDateTime) arg2;
			return new SimpleDateFormat("dd/MM/yyyy").format(localDateTime.toDate());
		}
		
		return null;
	}

}
