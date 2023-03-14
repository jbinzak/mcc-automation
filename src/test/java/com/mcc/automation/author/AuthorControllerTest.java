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
import org.springframework.test.web.servlet.result.JsonPathResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthorControllerTest {

	@Autowired
	private MockMvc myMockMvc;


	
	@Test
	public void api_endpoint_GET_Author_Response_is_200() throws Exception {

		// build request
		MockHttpServletRequestBuilder myMockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/author");

		// perform request
		ResultActions myResultsActions = myMockMvc.perform(myMockHttpServletRequestBuilder);

		// test result
		myResultsActions.andExpect(status().is(200));
	}


	
	@Test
	public void api_endpoint_PUT_Author_Response_is_405() throws Exception {

		// build request
		MockHttpServletRequestBuilder myMockHttpServletRequestBuilder = MockMvcRequestBuilders.put("/author");

		// perform request
		ResultActions myResultsActions = myMockMvc.perform(myMockHttpServletRequestBuilder);

		// test result
		myResultsActions.andExpect(status().is(405));
	}



	
	@Test
	public void api_endpoint_GET_Author_Response_Data_Has_Name() throws Exception {

		// build request
		MockHttpServletRequestBuilder myMockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/author");

		// perform request
		ResultActions myResultsActions = myMockMvc.perform(myMockHttpServletRequestBuilder);

		// get json
		JsonPathResultMatchers myJsonPathResultMatchers = jsonPath("$.name");

		// test result
		myResultsActions.andExpect(myJsonPathResultMatchers.isNotEmpty());
	}







	/*@Test
	public void getAuthorNameData() throws Exception {
		myMockMvc.perform(MockMvcRequestBuilders.get("/author").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("John"));
	}



	@Test
	public void getAuthorNameNotOk() throws Exception {
		myMockMvc.perform(MockMvcRequestBuilders.get("/author").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isRequestTimeout());
	}


	@Test
	public void getAuthorNameParam() throws Exception {
		myMockMvc.perform(MockMvcRequestBuilders.get("/author?mcc=Joe").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.name").value("Joe"));
	}*/

}
