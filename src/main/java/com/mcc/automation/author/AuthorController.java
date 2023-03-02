package com.mcc.automation.author;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

	@GetMapping("/author")
	public String getAuthorName() {
		Author author = new Author("John");
		return author.getName();
	}


}
