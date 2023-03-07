package com.mcc.automation.frontend;

//import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;


@SpringBootTest
public class FrontendControllerSeleniumTest {


	@Test
	public void first_Safari_Selenium() throws Exception {

		WebDriver driver = new SafariDriver();
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");

		//String title = driver.getTitle();

		WebElement textBox = driver.findElement(By.name("my-text"));

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));

		textBox.sendKeys("Selenium");


		WebElement submitButton = driver.findElement(By.cssSelector("button"));
		submitButton.click();

		WebElement message = driver.findElement(By.id("message"));
		String value = message.getText();

		Assert.assertEquals("Received!", value);

		driver.quit();

	}

	@Test
	public void first_Chrome_Selenium() throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.get("https://staging.mcc.com");

		//String title = driver.getTitle();

		WebElement textBox = driver.findElement(By.name("my-text"));

		//driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));

		textBox.sendKeys("Selenium");


		WebElement submitButton = driver.findElement(By.cssSelector("button"));
		submitButton.click();

		WebElement message = driver.findElement(By.id("message"));
		String value = message.getText();

		Assert.assertEquals("Received!", value);

		driver.quit();

	}

}
