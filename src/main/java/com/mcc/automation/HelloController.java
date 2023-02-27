package com.mcc.automation;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String index() {
		return "Hello Test Automation Class! Greetings from our Spring Boot project!";
	}

	@GetMapping("/blah")
	public String blah() {
		return "Hello blah!";
	}

}
