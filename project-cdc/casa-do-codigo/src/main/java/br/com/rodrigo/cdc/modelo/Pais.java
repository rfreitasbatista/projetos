package br.com.rodrigo.cdc.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;

	@Deprecated
	public Pais() {
	}
	
	public Pais(String nome2) {
		this.nome = nome2;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
