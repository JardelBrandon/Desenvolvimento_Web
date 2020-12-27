package br.com.ifpb.agenda_JSF.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("dddValidator")
public class DddValidator implements Validator {
	  private static final Pattern DDD_PATTERN = Pattern.compile("(\\d{2})");
	      
		@Override
		public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
			Matcher matcher = DDD_PATTERN.matcher(value.toString());
		      if (!matcher.matches()) {
		          FacesMessage msg =
		                  new FacesMessage("DDD Invalido",
		                          String.format("Entrada Inválida: %s!\n A entrada DDD deve seguir o seguinte formato (Apenas números): ##",
		                                  value));
		          msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		          throw new ValidatorException(msg);
		      }
			
		}
	  
	}