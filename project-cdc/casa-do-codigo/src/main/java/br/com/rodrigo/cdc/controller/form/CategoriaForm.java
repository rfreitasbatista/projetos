package br.com.rodrigo.cdc.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.rodrigo.cdc.annotations.UniqueValue;
import br.com.rodrigo.cdc.modelo.Categoria;

public class CategoriaForm {
	
	@NotNull
	@NotEmpty
	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "A categoria já está cadastrada")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria converter() {
		return new Categoria(nome);
	}

}
