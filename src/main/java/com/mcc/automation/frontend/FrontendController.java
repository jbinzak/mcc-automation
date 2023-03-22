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

	@GetMapping("/login")
	public String viewLoginPage(@RequestParam(name = "mcc", required = false) String mcc, @RequestParam(name = "err", required = false) String err, Model model) {

		Author author = new Author("John");

		// set data for UI
		model.addAttribute("mcc", mcc);
		model.addAttribute("err", err);
		model.addAttribute("author", author);


		return "login";
	}

	@GetMapping("/user-profile")
	public String submitLogin(@RequestParam(name = "email", required = false) String email, @RequestParam(name = "password", required = false) String password, Model model) {

		if(email.equalsIgnoreCase("john@mcc.com") && password.equalsIgnoreCase("password123")){

			return "user-profile";
		}
		
		return "redirect:/login?err=Invalid+credentials";
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
