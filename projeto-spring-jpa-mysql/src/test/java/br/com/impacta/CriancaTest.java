package br.com.impacta;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.impacta.AppStart;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = AppStart.class)
public class CriancaTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void exampleTest() {
		String body = this.restTemplate.getForObject("/crianca", String.class);
		assertThat(body.length()).isGreaterThan(0);
	}

	@Test
	public void exampleTest2() throws URISyntaxException {
	    ResponseEntity<Object[]> result = this.restTemplate.getForEntity("/crianca", Object[].class);
	    Object[] objects = result.getBody();
	     
	    //Verify request succeed
	    assertThat(objects.length > 0);
	    assertThat(result.getStatusCodeValue() == 200);
	}

}