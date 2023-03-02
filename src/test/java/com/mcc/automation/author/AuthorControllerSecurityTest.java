package com.mcc.automation.author;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthorControllerSecurityTest {

	@Autowired
	private MockMvc mvc;


	@Test
	public void getAuthorNameNoPost() throws Exception {
		mvc.perform(MockMvcRequestBuilders.delete("/author").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isMethodNotAllowed());
	}


}
