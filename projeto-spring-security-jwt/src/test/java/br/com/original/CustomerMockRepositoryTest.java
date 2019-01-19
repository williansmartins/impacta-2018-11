package br.com.original;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.original.model.Customer;
import br.com.original.service.CustomerService;

@RunWith(MockitoJUnitRunner.class)
public class CustomerMockRepositoryTest {
 
    @Mock
    private CustomerService customerService = new CustomerService();
    
    @Test
    public void givenMockingIsDoneByMockito_whenGetIsCalled_shouldReturnMockedObject() {
    	Customer customer = new Customer();
        customer.setName("Willians Martins");
        customer.setDate(new Date());
        customer.setEmail("contato@williansmartins.com");
        customer.setId(1l);
        
    	Mockito
        .when(customerService.getCustomerFromDataBase(1l))
        .thenReturn(customer);
    	
    	Customer customerFromDataBase = customerService.getCustomerFromDataBase(1l);
    	assertEquals(customer, customerFromDataBase);
    }
}