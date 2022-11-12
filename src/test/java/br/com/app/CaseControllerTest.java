package br.com.app;


import org.junit.jupiter.api.Test;
//import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

//@RunWith(SpringRunner.class)
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

}