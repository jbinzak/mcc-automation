package com.mcc.automation.login.selenium.safari;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.boot.test.context.SpringBootTest;

import com.mcc.automation.login.selenium.WebFormPageHelper;

@SpringBootTest
public class WebFormPageElementsExistSafariTest {
    
    @Test
    public void safari_web_form_text_input_exists() throws Exception{
        
        // create webdriver
        WebDriver myWebDriver = new SafariDriver();

        // get page
        myWebDriver.get(WebFormPageHelper.PAGE_URL);

        // query object
        By myElementSearchBy = By.id("my-text-id");

        // get element
        WebElement myWebElement = myWebDriver.findElement(myElementSearchBy);

        // verify element exists
        Assertions.assertThat(myWebElement).isNotNull();

        // close/quit browser connection
        myWebDriver.quit();
    }



    @Test
    public void safari_web_form_password_input_exists() throws Exception{

         // create webdriver
         WebDriver myWebDriver = new SafariDriver();

         // get page
         myWebDriver.get(WebFormPageHelper.PAGE_URL);
 
         // query object
         By myElementSearchBy = By.name("my-password");
 
         // get element
         WebElement myWebElement = myWebDriver.findElement(myElementSearchBy);
 
         // verify element exists
         Assertions.assertThat(myWebElement).isNotNull();
 
         // close/quit browser connection
         myWebDriver.quit();
    }

}
