package br.com.rodrigo.cdc.controller.form;

import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.rodrigo.cdc.annotations.CPFeCNPJ;
import br.com.rodrigo.cdc.annotations.Exists;
import br.com.rodrigo.cdc.modelo.Compra;
import br.com.rodrigo.cdc.modelo.Estado;
import br.com.rodrigo.cdc.modelo.Pais;
import br.com.rodrigo.cdc.repository.EstadoRepository;
import br.com.rodrigo.cdc.repository.PaisRepository;

public class CompraForm {

	@NotNull
	@NotBlank
	@NotEmpty
	@Email
	private String email;
	@NotNull
	@NotBlank
	@NotEmpty
	private String nome;
	@NotNull
	@NotBlank
	@NotEmpty
	private String sobrenome;
	@NotNull
	@NotBlank
	@NotEmpty
	@CPFeCNPJ(message = "CPF ou CNPJ inválidos")
	private String documento;
	@NotNull
	@NotBlank
	@NotEmpty
	private String endereco;
	@NotNull
	@NotBlank
	@NotEmpty
	private String complemento;
	@NotNull
	@NotBlank
	@NotEmpty
	private String cidade;
	@Exists(domainClass = Pais.class, fieldName = "nome", message = "País inválido")
	private String pais;
	private String estado;
	@NotNull
	@NotBlank
	@NotEmpty
	private String telefone;
	@NotNull
	@NotBlank
	@NotEmpty
	private String cep;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Compra converter(EstadoRepository estadoRepository, PaisRepository paisRepository) {
		Optional<Pais> paisObj = paisRepository.findByNome(pais);
		Optional<Estado> estadosPorPais = estadoRepository.findByPaisNome(pais);

		if (estadosPorPais.isPresent()) {
			Optional<Estado> estadoObj = estadoRepository.findByNome(estado);
			if (estadoObj.isEmpty())
				throw new IllegalStateException("O valor do campo Estado é inexistente");
			return new Compra(email, nome, sobrenome, documento, endereco, complemento, cidade, paisObj.get(),
					estadoObj.get(), telefone, cep);
		}

		return new Compra(email, nome, sobrenome, documento, endereco, complemento, cidade, paisObj.get(), null,
				telefone, cep);
	}

}
