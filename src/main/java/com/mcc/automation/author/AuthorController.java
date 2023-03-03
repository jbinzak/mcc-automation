package com.mcc.automation.author;


import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {

	@GetMapping("/author")
	public Author getAuthor(@RequestParam(name = "mcc", required = false) String mcc) {
		Author author = new Author(mcc != null ? mcc : "John");
		System.out.println(mcc);
		return author;
	}


	@PostMapping("/author")
	public Author getAuthor(@Valid @RequestBody Author authorDTO) {
		Author author = new Author(authorDTO.getName());
		return author;
	}


}
