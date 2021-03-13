package br.com.rodrigo.cdc.controller.dto;

import br.com.rodrigo.cdc.modelo.Livro;

public class DetalhesDoLivroDto extends LivroDto {

	private Integer id;

	public DetalhesDoLivroDto(Livro livro) {
		super(livro);
		this.id = livro.getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
