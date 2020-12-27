package br.com.ifpb.agenda_JSF.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("numeroValidator")
public class NumeroValidator implements Validator {
	  private static final Pattern CELULAR_PATTERN = Pattern.compile("(\\d{1}).(\\d{4})-(\\d{4})");
	  private static final Pattern TELEFONE_PATTERN = Pattern.compile("(\\d{4})-(\\d{4})");
	      
		@Override
		public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
			Matcher celular_matcher = CELULAR_PATTERN.matcher(value.toString());
			Matcher telefone_matcher = TELEFONE_PATTERN.matcher(value.toString());
		      if (!celular_matcher.matches() && !telefone_matcher.matches()) {
		          FacesMessage msg =
		                  new FacesMessage("Numero Invalido",
		                          String.format("Entrada Inválida: %s!\n A entrada deve seguir o seguinte formato"
		                          		+ "(Apenas números): #.####-#### - Celular || ####-#### - Telefone", value));
		          msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		          throw new ValidatorException(msg);
		      }
			
		}
	  
	}