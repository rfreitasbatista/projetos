package br.com.rodrigo.cdc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodrigo.cdc.controller.dto.CompraDto;
import br.com.rodrigo.cdc.controller.form.CompraForm;
import br.com.rodrigo.cdc.modelo.Compra;
import br.com.rodrigo.cdc.repository.CompraRepository;
import br.com.rodrigo.cdc.repository.EstadoRepository;
import br.com.rodrigo.cdc.repository.PaisRepository;
import br.com.rodrigo.cdc.validation.errorDto.ErroDeFormularioDto;

@RestController
@RequestMapping(value = "/compra")
public class CompraController {

	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private CompraRepository compraRepository;
	
	@PostMapping
	public ResponseEntity<Object> cadastrar(@RequestBody @Valid CompraForm form) {
		try {
			Compra compra = form.converter(estadoRepository, paisRepository);
			compraRepository.save(compra);
			return ResponseEntity.ok(new CompraDto(compra));			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErroDeFormularioDto("estado", e.getLocalizedMessage()));
		}
	}
	
}
