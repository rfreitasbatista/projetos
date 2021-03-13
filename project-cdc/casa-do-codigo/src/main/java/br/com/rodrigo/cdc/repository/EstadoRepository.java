package br.com.rodrigo.cdc.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.rodrigo.cdc.modelo.Estado;

public interface EstadoRepository extends CrudRepository<Estado, Integer> {

	Optional<Estado> findByNome(String estado);

	Optional<Estado> findByPaisNome(String pais);

}
