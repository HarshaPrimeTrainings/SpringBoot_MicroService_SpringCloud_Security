package com.training.springmvcdemo.controllers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{

	@Bean
	public InternalResourceViewResolver initResolver() {
		InternalResourceViewResolver ir = new InternalResourceViewResolver();
		ir.setPrefix("/");
		ir.setSuffix(".html");
		return ir;
	}
	

	
}
