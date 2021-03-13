package br.com.rodrigo.cdc.controller.dto;

import java.time.LocalDateTime;

import br.com.rodrigo.cdc.modelo.Autor;

public class AutorDto {

	private String nome;
	private String email;
	private String descricao;
	private LocalDateTime dataCadastro;

	public AutorDto(Autor autor) {
		this.nome = autor.getNome();
		this.descricao = autor.getDescricao();
		this.email = autor.getEmail();
		this.dataCadastro = autor.getDataCadastro();
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

}
