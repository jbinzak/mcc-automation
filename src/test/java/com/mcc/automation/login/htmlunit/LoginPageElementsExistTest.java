package com.mcc.automation.login.htmlunit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.web.context.WebApplicationContext;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlEmailInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;

@SpringBootTest
public class LoginPageElementsExistTest {
    



    private WebClient webClient;

    @BeforeEach
    void setup(WebApplicationContext context){
        this.webClient = MockMvcWebClientBuilder.webAppContextSetup(context).build();
    }

    @AfterEach
    void cleanUp(){
        this.webClient.close();
    }


    @Test
    public void login_form_email_input_exists() throws Exception{

        // get the html from a url
        HtmlPage myHtmlPage = this.webClient.getPage(LoginPageHelper.LOGIN_PAGE_URL);

        // get the input field by ID
        HtmlEmailInput myHtmlEmailInput = myHtmlPage.getHtmlElementById(LoginPageHelper.LOGIN_PAGE_INPUT_ID_EMAIL);
        
        // verify input exists
        Assertions.assertThat(myHtmlEmailInput).isNotNull();

    }

    @Test
    public void login_form_password_input_exists() throws Exception{

        // get the html from a url
        HtmlPage myHtmlPage = this.webClient.getPage(LoginPageHelper.LOGIN_PAGE_URL);

        // get the input field by ID
        HtmlPasswordInput myHtmlPasswordInput = myHtmlPage.getHtmlElementById(LoginPageHelper.LOGIN_PAGE_INPUT_ID_PASSWORD);
        
        // verify input exists
        Assertions.assertThat(myHtmlPasswordInput).isNotNull();

    }

    @Test
    public void login_form_login_button_exists() throws Exception{

        // get the html from a url
        HtmlPage myHtmlPage = this.webClient.getPage(LoginPageHelper.LOGIN_PAGE_URL);

        // get the button by ID
        HtmlButton myHtmlButton = myHtmlPage.getHtmlElementById(LoginPageHelper.LOGIN_PAGE_BUTTON_ID_LOGIN);
        
        // verify button exists
        Assertions.assertThat(myHtmlButton).isNotNull();

    }

}
