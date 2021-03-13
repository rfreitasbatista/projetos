package br.com.rodrigo.cdc.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.rodrigo.cdc.annotations.UniqueValue;
import br.com.rodrigo.cdc.modelo.Pais;

public class PaisForm {

	@NotNull
	@NotEmpty
	@NotBlank
	@UniqueValue(fieldName = "nome", domainClass = Pais.class, message = "O nome do país deve ser único")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Pais converter() {
		return new Pais(nome);
	}
}
