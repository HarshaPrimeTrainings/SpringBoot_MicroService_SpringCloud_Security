package com.training.stsdemo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
public class Demo {

	public void greet() {
		System.out.println("Demo Bean");
	}
	
	
}
