package br.com.rodrigo.cdc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodrigo.cdc.controller.dto.DetalhesDoLivroDto;
import br.com.rodrigo.cdc.controller.dto.LivroDto;
import br.com.rodrigo.cdc.controller.dto.LivroResumidoDto;
import br.com.rodrigo.cdc.controller.form.LivroForm;
import br.com.rodrigo.cdc.modelo.Livro;
import br.com.rodrigo.cdc.repository.AutorRepository;
import br.com.rodrigo.cdc.repository.CategoriaRepository;
import br.com.rodrigo.cdc.repository.LivroRepository;
import br.com.rodrigo.cdc.validation.errorDto.NotFoundErrorDto;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<LivroDto> cadastrar(@RequestBody @Valid LivroForm form) throws MethodArgumentNotValidException {
		Livro livro = form.converter(autorRepository, categoriaRepository);

		livroRepository.save(livro);

		return ResponseEntity.ok(new LivroDto(livro));
	}

	@GetMapping
	public List<LivroResumidoDto> visualizar() {
		Iterable<Livro> listLivro = livroRepository.findAll();

		List<LivroResumidoDto> list = new ArrayList<>();
		listLivro.forEach(livro -> list.add(LivroResumidoDto.converter(livro)));

		return list;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> detalhar(@PathVariable("id") Integer codigo) {
		Optional<Livro> livro = livroRepository.findById(codigo);
		if (livro.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoLivroDto(livro.get()));
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new NotFoundErrorDto(codigo, "Id inexistente"));
	}
}
