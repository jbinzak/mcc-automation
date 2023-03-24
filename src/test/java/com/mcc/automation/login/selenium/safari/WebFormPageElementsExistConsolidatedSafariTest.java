package com.mcc.automation.login.selenium.safari;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.boot.test.context.SpringBootTest;

import com.mcc.automation.login.selenium.WebFormPageHelper;

@SpringBootTest
public class WebFormPageElementsExistConsolidatedSafariTest {
    
    @Test
    public void safari_web_form_text_input_exists() throws Exception{

        // build list of element queries
        final List<By> myElementSearchBys = new ArrayList<By>();
        myElementSearchBys.add(By.id("my-text-id"));

        safari_element_exists(WebFormPageHelper.PAGE_URL, myElementSearchBys);
    }



    @Test
    public void safari_web_form_password_input_exists() throws Exception{

        // build list of element queries
        final List<By> myElementSearchBys = new ArrayList<By>();
        myElementSearchBys.add(By.name("my-password"));

         safari_element_exists(WebFormPageHelper.PAGE_URL, myElementSearchBys);
    }


    @Test
    public void safari_web_form_text_and_password_input_exists() throws Exception{

        // build list of element queries
        final List<By> myElementSearchBys = new ArrayList<By>();
        myElementSearchBys.add(By.id("my-text-id"));
        myElementSearchBys.add(By.name("my-password"));

         safari_element_exists(WebFormPageHelper.PAGE_URL, myElementSearchBys);
    }



    /**
     * 
     * @param url
     * @param myElementSearchBy
     * @throws Exception
     */
    public void safari_element_exists(String url, List<By> myElementSearchBys) throws Exception{

        // create webdriver
        WebDriver myWebDriver = new SafariDriver();

        // get page
        myWebDriver.get(url);

        // loop through elements 
        for(By myElementSearchBy : myElementSearchBys){

            // get element
            WebElement myWebElement = myWebDriver.findElement(myElementSearchBy);

            // verify element exists
            Assertions.assertThat(myWebElement).isNotNull();

        }

        // close/quit browser connection
        myWebDriver.quit();

    }
}
