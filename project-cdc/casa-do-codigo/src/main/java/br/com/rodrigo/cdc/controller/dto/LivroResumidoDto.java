package br.com.rodrigo.cdc.controller.dto;

import br.com.rodrigo.cdc.modelo.Livro;

public class LivroResumidoDto {

	private Integer id;
	private String titulo;
	
	

	public LivroResumidoDto(Livro livro) {
		super();
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public static LivroResumidoDto converter(Livro livro) {
		return new LivroResumidoDto(livro);
	}

}
