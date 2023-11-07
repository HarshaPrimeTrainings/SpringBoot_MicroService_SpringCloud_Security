package com.training.userservice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class UserController {

	@RequestMapping("/greet")
	public String greet() {
		return "Hello From USerService";
	}
	
	
}
