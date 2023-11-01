package com.training.springmvcdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetController {

	@RequestMapping("/greet")
	public String greetUser() {
		System.out.print("-----Greet User ------");
		return "hello";
	}
}
