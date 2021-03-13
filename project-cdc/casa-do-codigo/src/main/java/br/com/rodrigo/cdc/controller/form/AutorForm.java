package br.com.rodrigo.cdc.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.rodrigo.cdc.annotations.UniqueValue;
import br.com.rodrigo.cdc.modelo.Autor;

public class AutorForm {

	@NotEmpty
	@NotNull
	@NotBlank
	private String nome;
	@Email
	@NotEmpty
	@NotNull
	@UniqueValue(domainClass = Autor.class, fieldName = "email", message = "O email já está cadastrado")
	private String email;
	@NotNull
	@NotEmpty
	@NotBlank
	@Size(max = 400)
	private String descricao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Autor converter() {
		return new Autor(nome, email, descricao);
	}
}
