package br.com.impacta.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.impacta.repository.CriancaRepository;



@Controller
@RequestMapping("/crianca")
public class CriancaController {
	
	@Autowired
	private CriancaRepository repositorio;

	@RequestMapping(value="", method=RequestMethod.POST)  
	@ResponseBody
	public Crianca inserir(@RequestBody Crianca entrada) {
		repositorio.save(entrada);
		return entrada;
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)  
	@ResponseBody
	public ResponseEntity<List<Crianca>> buscarTodos() {
		
		List<Crianca> lista = (List<Crianca>) repositorio.findAll();		
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
		repositorio.delete(Long.valueOf(id));
		System.out.println("Deletando o id:" + id);
		return new ResponseEntity<Crianca>(new Crianca(), HttpStatus.INTERNAL_SERVER_ERROR) ;
	}
	

	
}
