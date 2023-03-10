package com.mcc.automation.author;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthorControllerTest {

	@Autowired
	private MockMvc mvc;


	@Test
	public void getAuthorNameOk() throws Exception {

		// build request
		MockHttpServletRequestBuilder myMockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/author");

		// perform request
		ResultActions myResultsActions = mvc.perform(myMockHttpServletRequestBuilder);

		// test result
		myResultsActions.andExpect(status().isOk());
	}

	@Test
	public void getAuthorNameNotOk() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/author").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isRequestTimeout());
	}

	@Test
	public void getAuthorNameData() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/author").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.name").value("John"));
	}

	@Test
	public void getAuthorNameParam() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/author?mcc=Joe").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.name").value("Joe"));
	}

}
