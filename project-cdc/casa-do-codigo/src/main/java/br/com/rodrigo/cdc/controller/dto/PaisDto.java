package br.com.rodrigo.cdc.controller.dto;

import br.com.rodrigo.cdc.modelo.Pais;

public class PaisDto {
	
	private String nome;

	public PaisDto(Pais pais) {
		this.nome = pais.getNome();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
