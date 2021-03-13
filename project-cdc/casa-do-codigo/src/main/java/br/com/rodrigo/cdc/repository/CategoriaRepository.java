package br.com.rodrigo.cdc.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rodrigo.cdc.modelo.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Integer>{

	Optional<Categoria> findByNome(String nome);

}
