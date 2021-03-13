package br.com.rodrigo.cdc.controller.dto;

import br.com.rodrigo.cdc.modelo.Estado;
import br.com.rodrigo.cdc.modelo.Pais;

public class EstadoDto {

	private String nome;
	private Pais pais;

	public EstadoDto(Estado estado) {
		super();
		this.nome = estado.getNome();
		this.pais = estado.getPais();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	

}
