package br.com.impacta.teste;

import br.com.impacta.entity.Pessoa;

public class PessoaMassa {
	
	Pessoa popularPessoa(){
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Willians Martins");
		pessoa.setIdade(32);
		pessoa.setSexo('M');
		return pessoa;
	}
}
