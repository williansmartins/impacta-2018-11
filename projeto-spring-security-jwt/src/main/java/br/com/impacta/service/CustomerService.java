package br.com.impacta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.impacta.model.Customer;
import br.com.impacta.repository.CustomerRepository;

@Service
public class CustomerService {
     
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private CustomerRepository repository;
 
    public Customer getCustomer(Long id) {
    	ResponseEntity<Customer> resp = restTemplate.getForEntity("http://localhost:8080/customer/" + id, Customer.class);
    	return resp.getStatusCode() == HttpStatus.OK ? (Customer)resp.getBody() : null;
    }
    
    public Customer getCustomerFromDataBase(Long id) {
    	Customer customer = repository.findOne(id);
    	return customer;
    }
}