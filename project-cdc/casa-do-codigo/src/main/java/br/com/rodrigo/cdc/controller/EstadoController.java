package br.com.rodrigo.cdc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodrigo.cdc.controller.dto.EstadoDto;
import br.com.rodrigo.cdc.controller.form.EstadoForm;
import br.com.rodrigo.cdc.modelo.Estado;
import br.com.rodrigo.cdc.repository.EstadoRepository;
import br.com.rodrigo.cdc.repository.PaisRepository;

@RestController
@RequestMapping(value = "/estado")
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private PaisRepository paisRepository;
	
	@PostMapping
	public ResponseEntity<EstadoDto> cadastrar(@RequestBody @Valid EstadoForm form) {
		Estado estado = form.converter(paisRepository);
		
		estadoRepository.save(estado);
		
		return ResponseEntity.ok(new EstadoDto(estado));
	}
}
