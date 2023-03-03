package com.mcc.automation.frontend;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.web.context.WebApplicationContext;


@SpringBootTest
public class FrontendControllerTest {

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
	public void givenAClient_whenEnteringHome_thenPageTitleIsOk() throws Exception {

		HtmlPage page = this.webClient.getPage("http://localhost");

		Assert.assertEquals(
				"Blah",
				page.getTitleText());

	}

	@Test
	public void getFormTestIsNotNull() throws Exception {

		HtmlPage page = this.webClient.getPage("http://localhost");


		HtmlForm form = page.getHtmlElementById("messageForm");

		Assertions.assertThat(form).isNotNull();

	}

}
