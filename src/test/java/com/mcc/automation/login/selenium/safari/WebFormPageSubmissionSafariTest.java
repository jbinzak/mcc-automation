package com.mcc.automation.login.selenium.safari;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.boot.test.context.SpringBootTest;

import com.mcc.automation.login.selenium.WebFormPageHelper;

@SpringBootTest
public class WebFormPageSubmissionSafariTest {
    
        

    @Test
    public void safari_web_form_submission_next_page_has_valid_message() throws Exception{

         // create webdriver
         WebDriver myWebDriver = new SafariDriver();

         // get page
         myWebDriver.get(WebFormPageHelper.PAGE_URL);
 
         // query object
         By myTextInputSearchBy = By.id("my-text-id");
 
         // get element
         WebElement myTextInputElement = myWebDriver.findElement(myTextInputSearchBy);
 
         // set value
         myTextInputElement.sendKeys("Hello World");

         // query object
         By mySubmitButtonSearchBy = By.cssSelector("button");
 
         // get element
         WebElement mySubmitButtonElement = myWebDriver.findElement(mySubmitButtonSearchBy);
 
         // click
         mySubmitButtonElement.click();

         // query object
         By myMessageSearchBy = By.id("message");
 
         // get element
         WebElement myMessageElement = myWebDriver.findElement(myMessageSearchBy);

         // verify element has value
         Assert.assertEquals("Received!", myMessageElement.getText());
 
         // close/quit browser connection
         myWebDriver.quit();
    }

}
