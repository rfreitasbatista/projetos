package br.com.rodrigo.cdc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodrigo.cdc.controller.dto.PaisDto;
import br.com.rodrigo.cdc.controller.form.PaisForm;
import br.com.rodrigo.cdc.modelo.Pais;
import br.com.rodrigo.cdc.repository.PaisRepository;

@RestController
@RequestMapping(value = "/pais")
public class PaisController {

	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping
	public ResponseEntity<PaisDto> cadastrar(@RequestBody @Valid PaisForm form) {
		Pais pais = form.converter();
		
		paisRepository.save(pais);
		
		return ResponseEntity.ok(new PaisDto(pais));
	}
}
