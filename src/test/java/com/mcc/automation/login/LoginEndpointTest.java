package com.mcc.automation.login;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.JsonPathResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcc.automation.auth.UserLoginRequest;

import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest
@AutoConfigureMockMvc
public class LoginEndpointTest{

    // constant for the endpoint url
    public static String LOGIN_ENDPOINT_URL = "/login";

	@Autowired
	private MockMvc myMockMvc;


    @Test
    public void verify_correct_user_credentials_response_code_is_200_and_response_data_is_valid() throws Exception {
        
        // perform login request
        ResultActions myResultsActions = performLoginRequest("john@mcc.com", "password123");
        
        // get json
		JsonPathResultMatchers myJsonPathResultMatchers = jsonPath("$.name");
        
		// test result
		myResultsActions.andExpect(status().is(200)).andExpect(myJsonPathResultMatchers.isNotEmpty());
    }


    @Test
    public void exploratory_invalid_user_credentials() throws Exception {
        
        // perform login request
        ResultActions myResultsActions = performLoginRequest("john@mcc.com", "foobar123");
        
        // get json
		JsonPathResultMatchers myJsonPathResultMatchers = jsonPath("$.name");
        
		// test result
		myResultsActions.andExpect(status().is(200)).andExpect(myJsonPathResultMatchers.isNotEmpty());
    }



    private ResultActions performLoginRequest(String email, String password) throws Exception{

        // test object with test data
        UserLoginRequest myUserLoginRequest = new UserLoginRequest();
        myUserLoginRequest.setEmail(email);
        myUserLoginRequest.setPassword(password);

		// build request
		MockHttpServletRequestBuilder myMockHttpServletRequestBuilder = MockMvcRequestBuilders.post(LoginEndpointTest.LOGIN_ENDPOINT_URL).contentType(MediaType.APPLICATION_JSON).content(convertObjectToJsonString(myUserLoginRequest));

		// perform request
		return myMockMvc.perform(myMockHttpServletRequestBuilder);
    }




    public static String convertObjectToJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}