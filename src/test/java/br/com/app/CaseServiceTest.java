package br.com.app;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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
		
		Optional<CaseModel> OptionalCaseModel = caseService.getCase("TEST_VALUE");
		System.out.println(OptionalCaseModel.get().getValue());
		Assertions.assertEquals("TEST_VALUE",OptionalCaseModel.get().getValue());  
	}
	
	@BeforeEach
	public void setap() {
		CaseModel caseModel = new CaseModel("TEST_VALUE",LocalDateTime.now());
		System.out.println(caseModel.toString());
		
		Mockito.when(caseRepository.findByValue(caseModel.getValue()))
		.thenReturn(java.util.Optional.of(caseModel));
	}
}
