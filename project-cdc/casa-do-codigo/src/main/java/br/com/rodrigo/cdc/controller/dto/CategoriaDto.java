package br.com.rodrigo.cdc.controller.dto;

import br.com.rodrigo.cdc.modelo.Categoria;

public class CategoriaDto {

	private String nome;

	public CategoriaDto(Categoria categoria) {
		this.nome = categoria.getNome();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
