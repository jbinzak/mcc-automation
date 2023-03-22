package com.mcc.automation.auth;


import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

	@PostMapping("/login")
	public User loginUser(@Valid @RequestBody UserLoginRequest userLoginRequest) throws Exception {

		if(userLoginRequest.getEmail().equalsIgnoreCase("john@mcc.com") && userLoginRequest.getPassword().equalsIgnoreCase("password123")){

			User author = new User("John");
			return author;
		}
		

		return null;
	}


}
