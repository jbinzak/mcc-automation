package com.mcc.automation.login.htmlunit;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.web.context.WebApplicationContext;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlEmailInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;

@SpringBootTest
public class LoginSubmissionTest {
    

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
    public void login_submission_valid_credentials_valid_navigation_valid_page_title() throws Exception{

        // get the html from a url
        HtmlPage myHtmlPage = this.webClient.getPage(LoginPageHelper.LOGIN_PAGE_URL);

        // get the input field by ID
        HtmlEmailInput myHtmlEmailInput = myHtmlPage.getHtmlElementById(LoginPageHelper.LOGIN_PAGE_INPUT_ID_EMAIL);

        // set email
        myHtmlEmailInput.setValue("john@mcc.com");

        // get the input field by ID
        HtmlPasswordInput myHtmlPasswordInput = myHtmlPage.getHtmlElementById(LoginPageHelper.LOGIN_PAGE_INPUT_ID_PASSWORD);

        // set password
        myHtmlPasswordInput.setValue("password123");

        // get the button by ID
        HtmlButton myHtmlButton = myHtmlPage.getHtmlElementById(LoginPageHelper.LOGIN_PAGE_BUTTON_ID_LOGIN);

        // click button
        HtmlPage myNextHtmlPage = myHtmlButton.click();

        // verify page title
        Assert.assertEquals("MCC Library User Profile", myNextHtmlPage.getTitleText());
    }

    
    @Test
    public void login_submission_invalid_credentials_prompts_error_message() throws Exception{

        // get the html from a url
        HtmlPage myHtmlPage = this.webClient.getPage(LoginPageHelper.LOGIN_PAGE_URL);

        // get the input field by ID
        HtmlEmailInput myHtmlEmailInput = myHtmlPage.getHtmlElementById(LoginPageHelper.LOGIN_PAGE_INPUT_ID_EMAIL);

        // set email
        myHtmlEmailInput.setValue("john@mcc.com");

        // get the input field by ID
        HtmlPasswordInput myHtmlPasswordInput = myHtmlPage.getHtmlElementById(LoginPageHelper.LOGIN_PAGE_INPUT_ID_PASSWORD);

        // set password
        myHtmlPasswordInput.setValue("foobar");

        // get the button by ID
        HtmlButton myHtmlButton = myHtmlPage.getHtmlElementById(LoginPageHelper.LOGIN_PAGE_BUTTON_ID_LOGIN);

        // click button
        HtmlPage myNextHtmlPage = myHtmlButton.click();

        // get the error message element by ID
        HtmlElement myHtmlElement = myNextHtmlPage.getHtmlElementById("errMessage");

        // verify error message
        Assert.assertEquals("Invalid credentials", myHtmlElement.getTextContent());
    }
}
