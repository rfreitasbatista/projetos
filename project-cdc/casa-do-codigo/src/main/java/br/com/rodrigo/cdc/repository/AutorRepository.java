package br.com.rodrigo.cdc.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rodrigo.cdc.modelo.Autor;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Integer>{

	Optional<Autor> findByEmail(String email);
	
	Optional<Autor> findByNome(String nome);

}
