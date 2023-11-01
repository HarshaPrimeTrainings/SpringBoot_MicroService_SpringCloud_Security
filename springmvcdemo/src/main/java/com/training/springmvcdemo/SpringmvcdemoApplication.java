package com.training.springmvcdemo;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.training.springmvcdemo.controllers.config.Demo;

@SpringBootApplication
public class SpringmvcdemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ioc = SpringApplication.run(SpringmvcdemoApplication.class, args);
		
		Demo d = ioc.getBean(Demo.class);
		
		System.out.println("-----> "+ d.userName);
	}

}
