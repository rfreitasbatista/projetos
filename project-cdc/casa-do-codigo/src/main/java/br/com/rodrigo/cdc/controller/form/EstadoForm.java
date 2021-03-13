package br.com.rodrigo.cdc.controller.form;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.rodrigo.cdc.annotations.Exists;
import br.com.rodrigo.cdc.annotations.UniqueValue;
import br.com.rodrigo.cdc.modelo.Estado;
import br.com.rodrigo.cdc.modelo.Pais;
import br.com.rodrigo.cdc.repository.PaisRepository;

public class EstadoForm {

	@NotNull
	@NotEmpty
	@NotBlank
	@UniqueValue(fieldName = "nome", domainClass = Estado.class, message = "O nome do estado deve ser único")
	private String nome;
	@NotNull
	@Exists(domainClass = Pais.class, fieldName = "nome", message = "País inexistente")
	private String pais;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public Estado converter(PaisRepository paisRepository) {
		
		Optional<Pais> paisObj = paisRepository.findByNome(pais);
		
		return new Estado(nome, paisObj.get());
	}
}
