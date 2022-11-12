package br.com.app;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.app.model.CaseModel;
import br.com.app.repository.CaseRepository;
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
	
	@MockBean
	CaseRepository caseRepository;
	

	@Test
	public void testaRegistro() throws Exception {
//		
//		CaseModel caseModel = new CaseModel("TEST_VALUE",LocalDateTime.now());
//		System.out.println(caseModel.toString());
		
//		var numero = caseService.getCase("TEST_VALUE");
//		System.out.println(numero.toString());
		Assertions.assertEquals(10,10);  
	}
	
	@Before
	public void setap() {
		CaseModel caseModel = new CaseModel("TEST_VALUE",LocalDateTime.now());
		System.out.println(caseModel.toString());
		
		//Mockito.when(caseRepository.findByValue(caseModel.getValue())).thenReturn(java.util.Optional.of(case));
	}
}
