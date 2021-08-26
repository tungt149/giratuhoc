package com.tuhocgira.welcome.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("/welcome")
	public Object Welcome() {
		return "Welcome to Gira Apllication";
	}

}
