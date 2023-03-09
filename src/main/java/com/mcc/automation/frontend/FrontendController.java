package com.mcc.automation.frontend;


import com.mcc.automation.author.Author;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FrontendController {

	@GetMapping("/")
	public String viewHomePage(@PathVariable(name = "mcc", required = false) String mcc, Model model) {

		Author author = new Author("John");

		// set data for UI
		model.addAttribute("mcc", mcc);
		model.addAttribute("author", author);


		return "home";
	}

	@GetMapping("/dash")
	public String viewDashPage(@PathVariable(name = "mcc", required = false) String mcc, Model model) {

		Author author = new Author("John");

		// set data for UI
		model.addAttribute("mcc", mcc);
		model.addAttribute("author", author);


		return "html/index";
	}

}
