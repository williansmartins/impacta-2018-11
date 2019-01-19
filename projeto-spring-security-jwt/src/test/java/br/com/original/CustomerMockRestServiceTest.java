package br.com.original;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.original.model.Customer;
import br.com.original.service.CustomerService;

@RunWith(MockitoJUnitRunner.class)
public class CustomerMockRestServiceTest {
	
    @Mock
    private RestTemplate restTemplate;
 
    @InjectMocks
    private CustomerService customerService = new CustomerService();
 
    @Test
    public void givenMockingIsDoneByMockito_whenGetIsCalled_shouldReturnMockedObject() {
        Customer customer = new Customer();
        customer.setName("Willians Martins");
        customer.setDate(new Date());
        customer.setEmail("contato@williansmartins.com");
        customer.setId(1l);
        
        Mockito
          .when(restTemplate.getForEntity("http://localhost:8080/customer/1", Customer.class))
          .thenReturn(new ResponseEntity(customer, HttpStatus.OK));
 
        Customer customer2 = customerService.getCustomer(1l);
        assertEquals(customer, customer2);
    }
}