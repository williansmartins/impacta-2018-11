package br.com.original.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.original.model.Cadastro;


@Controller
@RequestMapping("/cadastro")
public class CadastroController {
	
	@RequestMapping(value="", method=RequestMethod.POST)  
	@ResponseBody
	public Cadastro inserir(@RequestBody Cadastro cadastro){
		
		return cadastro;
		
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)  
	@ResponseBody
	public ResponseEntity<List<Cadastro>> buscarTodos(){
		

		List<Cadastro> lista = new ArrayList<>();
		
		/*Esse for � apenas para mudar o nome do usuario
		 * apagar o FOR depois*/
		for (int i = 1; i <= 10; i++) {
			Cadastro oCadastro = new Cadastro();
			oCadastro.setEmail("aluno" + Integer.valueOf(i) +"@gmail.com");
			oCadastro.setSenha("123");
			lista.add(oCadastro);
		}
		
		return new ResponseEntity<List<Cadastro>>(lista, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)  
	@ResponseBody
	public Cadastro buscar(@PathVariable String id) {
		Cadastro oCadastro = new Cadastro();
		oCadastro.setEmail("aluno@gmail.com");
		oCadastro.setId(1l);
		oCadastro.setSenha(id);
		return oCadastro;
	}

	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Cadastro> atualizar(@RequestBody Cadastro cadastro, @PathVariable String id) {
		
		System.out.println(cadastro);
		
		return new ResponseEntity<Cadastro>(cadastro, HttpStatus.OK); 
	}

	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Cadastro> deletar(@PathVariable String id) {
		System.out.println("Deletando o id:" + id);
		return new ResponseEntity<Cadastro>(new Cadastro(), HttpStatus.INTERNAL_SERVER_ERROR) ;
	}
	
	

}
