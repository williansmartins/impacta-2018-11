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
	public ResponseEntity<Crianca> buscar(Long id) {

		Crianca crianca = repositorio.findOne(Long.valueOf(id));
		return new ResponseEntity<Crianca>(crianca, HttpStatus.OK);
		
	}

	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Crianca> atualizar(@RequestBody Crianca criancaEntrada, @PathVariable Long id) {
		Crianca criancaSaida = repositorio.findOne(Long.valueOf(id));
		

		criancaSaida.setNome(criancaEntrada.getNome());
		criancaSaida.setNascimento(criancaEntrada.getNascimento());
		criancaSaida.setSexo(criancaEntrada.getSexo());
		criancaSaida.setUser_id(criancaEntrada.getUser_id());
		
		repositorio.save(criancaSaida);
		return new ResponseEntity<Crianca>(criancaSaida, HttpStatus.OK); 
	}

	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deletar(@PathVariable String id) {
		repositorio.delete(Long.valueOf(id));
		System.out.println("Deletando o id:" + id);
		return new ResponseEntity<String>("ok", HttpStatus.OK) ;
	}
	

	
}
