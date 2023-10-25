package com.training.stsdemo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.learning.beans.Product;
import com.training.stsdemo.beans.User;

@ComponentScan({"com.training.stsdemo","com.learning.beans"})
@SpringBootApplication
public class StsdemoApplication {

	public static void main(String[] args) {
		ApplicationContext ioc =  SpringApplication.run(StsdemoApplication.class, args);
		
		//Demo d = ioc.getBean(Demo.class);
		//d.greet();
		
		Demo d = ioc.getBean(Demo.class);
		System.out.println(" HashCode for obj d:: "+ d.hashCode());
		
		Demo d1 = ioc.getBean(Demo.class);
		System.out.println(" HashCode for obj d1:: "+ d1.hashCode());
		
		
		
	}

}
