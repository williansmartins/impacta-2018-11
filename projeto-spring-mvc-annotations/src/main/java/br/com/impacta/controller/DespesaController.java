package br.com.impacta.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.impacta.model.Categoria;
import br.com.impacta.model.Despesa;

@Controller
@RequestMapping("/despesa")
public class DespesaController {

	@RequestMapping(value="", method=RequestMethod.POST)  
	@ResponseBody
	public Despesa inserir(@RequestBody Despesa entrada) {
		return entrada;
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)  
	@ResponseBody
	public ResponseEntity<List<Despesa>> buscarTodos() {
		
		Despesa despesa = new Despesa();
		despesa.setCategoria(Categoria.ALIMENTACAO);
		despesa.setCodigo(1l);
		despesa.setData(new Date());
		despesa.setDescricao("descricao");
		despesa.setObservacoes("observacoes");
		despesa.setValor(new BigDecimal(123.45));
		
		List<Despesa> lista = new ArrayList<>();
		lista.add(despesa);
		lista.add(despesa);
		lista.add(despesa);
		
		return new ResponseEntity<List<Despesa>>(lista, HttpStatus.OK) ;
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)  
	@ResponseBody
	public Despesa buscar() {
		Despesa despesa = new Despesa();
		despesa.setCategoria(Categoria.ALIMENTACAO);
		despesa.setCodigo(1l);
		despesa.setData(new Date());
		despesa.setDescricao("descricao");
		despesa.setObservacoes("observacoes");
		despesa.setValor(new BigDecimal(123.45));
		return despesa;
	}

	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Despesa> atualizar(@RequestBody Despesa despesa, @PathVariable String id) {
		despesa.setDescricao(despesa.getDescricao() + "-nova");
		despesa.setObservacoes(despesa.getObservacoes() + "-nova");
		return new ResponseEntity<Despesa>(despesa, HttpStatus.OK); 
	}

	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Despesa> deletar(@PathVariable String id) {
		System.out.println("Deletando o id:" + id);
		return new ResponseEntity<Despesa>(new Despesa(), HttpStatus.INTERNAL_SERVER_ERROR) ;
	}
}
