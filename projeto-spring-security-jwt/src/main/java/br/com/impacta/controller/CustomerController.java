package br.com.impacta.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.impacta.model.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@RequestMapping(value="", method=RequestMethod.POST)  
	@ResponseBody
	public Customer inserir(@RequestBody Customer Customer){
		return Customer;
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)  
	@ResponseBody
	public ResponseEntity<List<Customer>> buscarTodos(){
		logger.info("Inicio do metodo buscar todos");
		List<Customer> lista = new ArrayList<>();
		
		for (int i = 1; i <= 10; i++) {
			Customer oCustomer = new Customer();
			oCustomer.setEmail("email-" + i +"@gmail.com");
			oCustomer.setName("Willians Martins - " + i);
			logger.info("gerando customer: " + i);
			lista.add(oCustomer);
		}
		
		return new ResponseEntity<List<Customer>>(lista, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)  
	@ResponseBody
	public Customer buscar(@PathVariable String id) {
		Customer oCustomer = new Customer();
		oCustomer.setEmail("contato@williansmartins.com");
		oCustomer.setId(1l);
		oCustomer.setName("Willians Martins");
		return oCustomer;
	}

	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Customer> atualizar(@RequestBody Customer Customer, @PathVariable String id) {
		return new ResponseEntity<Customer>(Customer, HttpStatus.OK); 
	}

	@ResponseBody
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Customer> deletar(@PathVariable String id) {
		System.out.println("Deletando o id:" + id);
		return new ResponseEntity<Customer>(new Customer(), HttpStatus.INTERNAL_SERVER_ERROR) ;
	}

}
