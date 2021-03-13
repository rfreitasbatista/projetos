package br.com.rodrigo.cdc.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.rodrigo.cdc.annotations.FutureDate;

public class FutureDateValidator implements ConstraintValidator<FutureDate, Object> {

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate futureDate = LocalDate.parse((String)value, dateFormat);
		
		return futureDate.isAfter(LocalDate.now());
	}
	
	
}


