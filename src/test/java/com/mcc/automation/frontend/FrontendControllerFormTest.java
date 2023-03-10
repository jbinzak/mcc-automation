package com.mcc.automation.frontend;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.web.context.WebApplicationContext;


@SpringBootTest
public class FrontendControllerFormTest {

	private WebClient webClient;

	@BeforeEach
	void setup(WebApplicationContext context) {
		this.webClient = MockMvcWebClientBuilder
				.webAppContextSetup(context)
				.build();
	}

	@AfterEach
	void cleanUp() {
		this.webClient.close();
	}


	@Test
	public void getFormTestIsNotNull() throws Exception {

		// get html from page
		HtmlPage myPage = this.webClient.getPage("http://localhost");

		// get form
		HtmlForm myForm = myPage.getHtmlElementById("messageForm");

		// test that form is not null aka that is exists
		Assertions.assertThat(myForm).isNotNull();

	}

	@Test
	public void getFormInputTestIsNotNull() throws Exception {

		HtmlPage page = this.webClient.getPage("http://localhost");


		HtmlTextInput summaryInput = page.getHtmlElementById("summary");

		Assertions.assertThat(summaryInput).isNotNull();

	}

	@Test
	public void getFormSubmit() throws Exception {

		HtmlPage page = this.webClient.getPage("http://localhost");


		HtmlForm form = page.getHtmlElementById("messageForm");

		HtmlTextInput summaryInput = page.getHtmlElementById("summary");
		summaryInput.setValueAttribute("Spring Rocks");

		HtmlSubmitInput submit = form.getOneHtmlElementByAttribute("input", "type", "submit");
		HtmlPage newMessagePage = submit.click();

		Assertions.assertThat(summaryInput).isNotNull();

	}

}
