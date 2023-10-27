package com.training.stsdemo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.training.stsdemo.beans.User;

@ComponentScan({"com.training.stsdemo","com.learning.beans"})
@SpringBootApplication
public class StsdemoApplication {

	public static void main(String[] args) {
		ApplicationContext ioc =  SpringApplication.run(StsdemoApplication.class, args);
		
	
		Product p = ioc.getBean(Product.class);
		p.getDiscount();
		
		
	}

}
