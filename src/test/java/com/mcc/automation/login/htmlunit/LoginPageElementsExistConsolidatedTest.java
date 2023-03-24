package com.mcc.automation.login.htmlunit;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.web.context.WebApplicationContext;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

@SpringBootTest
public class LoginPageElementsExistConsolidatedTest {
    
    public static String LOGIN_PAGE_BUTTON_ID_LOGIN = "loginBtn";



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
        verify_element_exists(LoginPageHelper.LOGIN_PAGE_URL, LoginPageHelper.LOGIN_PAGE_INPUT_ID_EMAIL);
    }

    @Test
    public void login_form_password_input_exists() throws Exception{
        verify_element_exists(LoginPageHelper.LOGIN_PAGE_URL, LoginPageHelper.LOGIN_PAGE_INPUT_ID_PASSWORD);
    }

    @Test
    public void login_form_login_button_exists() throws Exception{
        verify_element_exists(LoginPageHelper.LOGIN_PAGE_URL, LOGIN_PAGE_BUTTON_ID_LOGIN);
    }

    @Test
    public void login_form_email_label_exists() throws Exception{
        verify_element_exists(LoginPageHelper.LOGIN_PAGE_URL, "emailLabel");
    }

    @Test
    public void login_form_password_label_exists() throws Exception{
        verify_element_exists(LoginPageHelper.LOGIN_PAGE_URL, "passwordLabel");
    }


    @Test
    public void login_page_title_is_valid() throws Exception{

        // get the html from a url
        HtmlPage myHtmlPage = this.webClient.getPage(LoginPageHelper.LOGIN_PAGE_URL);

        // verify page title
        Assert.assertEquals("MCC Library Login", myHtmlPage.getTitleText());
    }


    @Test
    public void login_page_register_link_exists() throws Exception{
        verify_anchor_element_exists(LoginPageHelper.LOGIN_PAGE_URL, "/register");
    }


    @Test
    public void login_page_forgot_password_link_exists() throws Exception{
        verify_anchor_element_exists(LoginPageHelper.LOGIN_PAGE_URL, "/forgot-password");
    }



    public void verify_anchor_element_exists(String url, String href) throws Exception{

        // get the html from a url
        HtmlPage myHtmlPage = this.webClient.getPage(url);

        // getting element by href
        HtmlAnchor myHtmlAnchor = myHtmlPage.getAnchorByHref(href);

        // verify element exists
        Assertions.assertThat(myHtmlAnchor).isNotNull();  
    }


    /**
     * 
     * @param url
     * @param elementID
     * @throws Exception
     */
    public void verify_element_exists(String url, String elementID) throws Exception{

        // get the html from a url
        HtmlPage myHtmlPage = this.webClient.getPage(url);

        // get the element by ID
        HtmlElement myHtmlElement = myHtmlPage.getHtmlElementById(elementID);
        
        // verify element exists
        Assertions.assertThat(myHtmlElement).isNotNull();
    }
}
