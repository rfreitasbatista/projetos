package br.com.rodrigo.cdc.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.rodrigo.cdc.validation.CPFeCNPJValidator;

@Documented
@Constraint(validatedBy = {CPFeCNPJValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CPFeCNPJ {
	String message() default "{br.com.rodrigo.cdc.validation}";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
}
