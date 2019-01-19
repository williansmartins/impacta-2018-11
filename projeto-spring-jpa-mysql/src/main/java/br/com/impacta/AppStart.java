package br.com.impacta;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import br.com.impacta.dao.CustomerRepository;
import br.com.impacta.model.Customer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AppStart implements CommandLineRunner {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    DataSource dataSource;

    @Autowired
    CustomerRepository customerRepository;
    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AppStart.class, args);
    }
    
    

    @Override
    public void run(String... args) throws Exception {

        System.out.println("DATASOURCE = " + dataSource);
        
//        inserir();
//        buscar();
//        findByEmail();
//        findByDate();
//        findByEmailReturnStream();
//        findByDateBetween();
        System.out.println("Done!");

//        exit(0);
    }

	private void findByDateBetween() throws ParseException {
//		System.out.println("....................");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date from = sdf.parse("2017-02-15");
//        Date to = sdf.parse("2017-02-17");
//
//        for (Customer customer : customerRepository.findByDateBetween(from, to)) {
//            System.out.println(customer);
//        }
	}

	private void findByEmailReturnStream() {
		// For Stream, need @Transactional
        System.out.println("\n4.findByEmailReturnStream(@Param(\"email\") String email)...");
        try (Stream<Customer> stream = customerRepository.findByEmailReturnStream("333@yahoo.com")) {
            stream.forEach(x -> System.out.println(x));
        }
	}

	private void findByDate() throws ParseException {
		System.out.println("\n3.findByDate(Date date)...");
        for (Customer customer : customerRepository.findByDate(sdf.parse("2017-02-12"))) {
            System.out.println(customer);
        }
	}

	private void findByEmail() {
		System.out.println("\n2.findByEmail(String email)...");
        for (Customer customer : customerRepository.findByEmail("222@yahoo.com")) {
            System.out.println(customer);
        }
	}

	private void buscar() {
		System.out.println("\n1.findAll()...");
        for (Customer customer : customerRepository.findAll()) {
            System.out.println(customer);
        }
	}

	private void inserir() {
		Customer customer = new Customer();
        customer.setDate(new Date());
        customer.setEmail("email@teste.com");
        customer.setName("willians");
        
		customerRepository.save(customer);
	}

}