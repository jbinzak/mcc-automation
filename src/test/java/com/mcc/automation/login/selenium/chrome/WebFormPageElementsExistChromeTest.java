package com.mcc.automation.login.selenium.chrome;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

import com.mcc.automation.login.selenium.WebFormPageHelper;

@SpringBootTest
public class WebFormPageElementsExistChromeTest {
    
    @Test
    public void chrome_web_form_text_input_exists() throws Exception{
        
        // create webdriver
        WebDriver myWebDriver = new ChromeDriver();

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



}
