package br.com.impacta.controller;

import java.time.LocalDate;
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

import br.com.impacta.model.Crianca;
import br.com.impacta.model.enums.SexoEnum;



@Controller
@RequestMapping("/crianca")
public class CriancaController {
	
	@RequestMapping(value="", method=RequestMethod.POST)  
	@ResponseBody
	public Crianca inserir(@RequestBody Crianca entrada) {
		return entrada;
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)  
	@ResponseBody
	public ResponseEntity<List<Crianca>> buscarTodos() {
		
		Crianca crianca = new Crianca();
		crianca.setNome("Victor");
		crianca.setUser_id(1l);
		crianca.setSexo(SexoEnum.MASCULINO.getTipoSexo());
		crianca.setNascimento(LocalDate.now());
		
				
		List<Crianca> lista = new ArrayList<>();
		lista.add(crianca);
		lista.add(crianca);
		lista.add(crianca);
		
		return new ResponseEntity<List<Crianca>>(lista, HttpStatus.OK) ;
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)  
	@ResponseBody
	public Crianca buscar() {
		Crianca crianca = new Crianca();
		crianca.setNome("Victor");
		crianca.setUser_id(1l);
		crianca.setSexo(SexoEnum.MASCULINO.getTipoSexo());
		crianca.setNascimento(LocalDate.now());
		return crianca;
	}

	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Crianca> atualizar(@RequestBody Crianca crianca, @PathVariable String id) {
		
		System.out.println(crianca);
		
		return new ResponseEntity<Crianca>(crianca, HttpStatus.OK); 
	}

	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Crianca> deletar(@PathVariable String id) {
		System.out.println("Deletando o id:" + id);
		return new ResponseEntity<Crianca>(new Crianca(), HttpStatus.INTERNAL_SERVER_ERROR) ;
	}
	

	
}
