package br.com.rodrigo.cdc.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.rodrigo.cdc.controller.dto.AutorDto;
import br.com.rodrigo.cdc.controller.form.AutorForm;
import br.com.rodrigo.cdc.modelo.Autor;
import br.com.rodrigo.cdc.repository.AutorRepository;
import br.com.rodrigo.cdc.validation.deprecated.AutorUnicoValidation;

@RestController
@RequestMapping(value = "/autor")
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private AutorUnicoValidation validacaoDeAutorExistente;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(validacaoDeAutorExistente);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<AutorDto> cadastrar(@RequestBody @Valid AutorForm form, UriComponentsBuilder uriBuilder ) {
		Autor autor = form.converter();
		
		autorRepository.save(autor);
		
		
		return ResponseEntity.ok(new AutorDto(autor));
	}
}
