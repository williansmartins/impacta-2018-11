package br.com.impacta.teste;

import org.junit.Assert;
import org.junit.Test;

import br.com.impacta.dao.especific.PessoaDAOImpl;
import br.com.impacta.dao.generic.JpaGenericDao;
import br.com.impacta.entity.Pessoa;

public class PessoaDAOTest {

	JpaGenericDao<Pessoa> dao = new PessoaDAOImpl();
	
	@Test
	public void inserirPessoa() {
		Pessoa pessoaMockada = new PessoaMassa().popularPessoa();
		dao.insert(pessoaMockada);
		Assert.assertTrue(pessoaMockada.getId() != null);
	}

}
