package br.com.impacta.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.impacta.model.Crianca;

@Repository
public interface CriancaRepository extends CrudRepository<Crianca, Long> {

}
