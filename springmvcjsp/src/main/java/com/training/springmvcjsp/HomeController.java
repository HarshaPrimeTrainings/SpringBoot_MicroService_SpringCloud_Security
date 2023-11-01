package com.training.springmvcjsp;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value = "/greet")
	public String greet() {
		return "home";
	}
	
}
