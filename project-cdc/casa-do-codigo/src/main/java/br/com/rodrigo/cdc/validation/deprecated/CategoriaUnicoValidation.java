package br.com.rodrigo.cdc.validation.deprecated;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.rodrigo.cdc.controller.form.CategoriaForm;
import br.com.rodrigo.cdc.modelo.Categoria;
import br.com.rodrigo.cdc.repository.CategoriaRepository;

@Component
public class CategoriaUnicoValidation implements Validator {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// Teste de erro externo
		if (errors.hasErrors()) {
			return;
		}
		
		// Identificando qual request será atendido e pesquisando o nome da Categoria no banco
		CategoriaForm request = (CategoriaForm) target;
		Optional<Categoria> categoria = categoriaRepository.findByNome(request.getNome());

		if (categoria.isPresent()) {
			errors.rejectValue("nome", null, "A Categoria com nome " + request.getNome() + " já está cadastrada");
		}
	}
}
