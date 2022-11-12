package br.com.app;

import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.app.service.CaseService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CaseServiceTest {
	
	@TestConfiguration
	public class CaseServiceTestConfiguration{
		@Bean
		public CaseService caseService() {
			return new CaseService();
		}
	}
	
	@Autowired
	CaseService caseService;

		  @Test
		  public void testaRegistro() throws Exception {
			  int numero = caseService.ReturnQuantity();
		      Assertions.assertEquals(10,numero);  
		  }


}
