package br.com.app;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import br.com.app.model.CaseModel;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class CaseControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void caseTestGellAll() throws Exception{
		mockMvc.perform(get("/case"))
		.andExpect(status().isOk());
	}
	
	
	@Test
	public void caseTestSave() {
		CaseModel caseModel = new CaseModel(UUID.randomUUID(),"TEST_VALUE",LocalDateTime.now());
		System.out.println(caseModel.toString());
	}

}
