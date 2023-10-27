package com.training.stsdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Product {
	
	@Qualifier("elecdisc")
	@Autowired
	private Discount cd;

	public void getDiscount() {
		System.out.println(" Discount for Product "+ cd.getDiscount());
	}
	
}
