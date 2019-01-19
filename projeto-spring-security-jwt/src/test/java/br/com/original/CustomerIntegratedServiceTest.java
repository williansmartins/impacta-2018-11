package br.com.original;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.original.model.Customer;
import br.com.original.service.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppStart.class, webEnvironment=WebEnvironment.DEFINED_PORT)
public class CustomerIntegratedServiceTest {
 
 
    @Autowired
    private CustomerService customerService = new CustomerService();
 
    @Test
    public void integratedTest() {
        Customer customer = customerService.getCustomer(1l);
        assertEquals(customer.getName(), "Willians Martins");
    }
}