package com.mcc.automation.login.selenium.safari;

import org.junit.Assert;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.boot.test.context.SpringBootTest;

import com.mcc.automation.login.selenium.WebFormPageHelper;

@SpringBootTest
public class WebFormPageInputsSafariTest {
    

    @Test
    public void safari_web_form_disabled_input_is_disabled() throws Exception{

         // create webdriver
         WebDriver myWebDriver = new SafariDriver();

         // get page
         myWebDriver.get(WebFormPageHelper.PAGE_URL);
 
         // query object
         By myElementSearchBy = By.name("my-disabled");
 
         // get element
         WebElement myWebElement = myWebDriver.findElement(myElementSearchBy);
 
         // verify element is disabled
         Assertions.assertThat(myWebElement.isEnabled()).isFalse();
 
         // close/quit browser connection
         myWebDriver.quit();
    }


    @Test
    public void safari_web_form_text_input_myprop_value_correct() throws Exception{

         // create webdriver
         WebDriver myWebDriver = new SafariDriver();

         // get page
         myWebDriver.get(WebFormPageHelper.PAGE_URL);
 
         // query object
         By myElementSearchBy = By.id("my-text-id");
 
         // get element
         WebElement myWebElement = myWebDriver.findElement(myElementSearchBy);

        // verify attribute value
        Assert.assertEquals("myvalue", myWebElement.getAttribute("myprop"));
 
         // close/quit browser connection
         myWebDriver.quit();
    }


    @Test
    public void safari_web_form_select_input_has_correct_options() throws Exception{

        // create webdriver
        WebDriver myWebDriver = new SafariDriver();

        // get page
        myWebDriver.get(WebFormPageHelper.PAGE_URL);

        // query object
        By myElementSearchBy = By.name("my-select");

        // get element
        WebElement myWebElement = myWebDriver.findElement(myElementSearchBy);

        // get select object
        Select mySelect = new Select(myWebElement);

        // get all options
        List<WebElement> myOptions = mySelect.getOptions();

        // helper 
        int correctValuesFound = 0;

        // loop through options
        for(WebElement myOption : myOptions){
            
            int optionValue;
            try{
                optionValue = Integer.parseInt(myOption.getAttribute("value"));
            }catch(Exception e){
                optionValue = 0;
            }

            if(optionValue == 1 || optionValue == 2 || optionValue == 3){
                correctValuesFound++;
            }
            
        }

        // verify found value
        Assert.assertEquals(3, correctValuesFound);

        // close/quit browser connection
        myWebDriver.quit();
    }

}
