package br.com.rodrigo.cdc.repository;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.repository.CrudRepository;

import br.com.rodrigo.cdc.modelo.Pais;

public interface PaisRepository extends CrudRepository<Pais, Integer>{

	public Optional<Pais> findByNome(@NotNull @NotEmpty @NotBlank String nome);

}
