package br.com.app;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.app.model.CaseModel;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class CaseControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void caseTestGellAll() throws Exception{
		mockMvc.perform(get("/case"))
		.andExpect(status().isOk());
	}
	
	
	@Test
	public void caseTestSave() throws JsonProcessingException, Exception {
		CaseModel caseModel = new CaseModel("TEST_VALUE",LocalDateTime.now());

		
		mockMvc.perform(post("/case")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(caseModel)))
				.andExpect(status().isOk());
				
				
	}

}
