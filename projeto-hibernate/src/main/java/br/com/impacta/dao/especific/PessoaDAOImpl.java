package br.com.impacta.dao.especific;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.impacta.dao.generic.JpaGenericDao;
import br.com.impacta.entity.Pessoa;

public class PessoaDAOImpl extends JpaGenericDao<Pessoa> implements IPessoaDAO{
	
	@PersistenceContext
	private EntityManager entityManager;

	public PessoaDAOImpl() {
		entityManager = getEntityManager();
	}
	
	
}