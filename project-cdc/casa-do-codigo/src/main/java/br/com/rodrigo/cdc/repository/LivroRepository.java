package br.com.rodrigo.cdc.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.rodrigo.cdc.modelo.Livro;

public interface LivroRepository extends CrudRepository<Livro, Integer> {

}
