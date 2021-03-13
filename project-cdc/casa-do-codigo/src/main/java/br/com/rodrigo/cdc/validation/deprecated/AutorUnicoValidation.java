package br.com.rodrigo.cdc.validation.deprecated;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.rodrigo.cdc.controller.form.AutorForm;
import br.com.rodrigo.cdc.modelo.Autor;
import br.com.rodrigo.cdc.repository.AutorRepository;

@Component
public class AutorUnicoValidation implements Validator {

	@Autowired
	private AutorRepository autorRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return AutorForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		AutorForm request = (AutorForm) target;
		Optional<Autor> autor = autorRepository.findByEmail(request.getEmail());

		if (autor.isPresent()) {
			errors.rejectValue("email", null, "O email " + request.getEmail() + " já está cadastrado");
		}
	}

}
