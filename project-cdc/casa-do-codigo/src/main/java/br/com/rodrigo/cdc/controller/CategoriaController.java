package br.com.rodrigo.cdc.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodrigo.cdc.controller.dto.CategoriaDto;
import br.com.rodrigo.cdc.controller.form.CategoriaForm;
import br.com.rodrigo.cdc.modelo.Categoria;
import br.com.rodrigo.cdc.repository.CategoriaRepository;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository catRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<CategoriaDto> cadastrar(@RequestBody @Valid CategoriaForm form) {
		
		Categoria categoria = form.converter();
		
		catRepository.save(categoria);
		
		return ResponseEntity.ok(new CategoriaDto(categoria));
	}
}
