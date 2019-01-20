package br.com.impacta.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.impacta.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

}
