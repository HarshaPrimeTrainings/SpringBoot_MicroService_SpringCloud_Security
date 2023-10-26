package com.training.stsdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sandwich {

	
	Catogery ct;
	
	@Autowired
	Sandwich(Catogery ct){
		this.ct = ct;
	}
	
	public Catogery getCt() {
		return ct;
	}

	
	public void setCt(Catogery ct) {
		this.ct = ct;
	}


	public void getSandwich() {
		System.out.println("Sanwich type is "+ ct.getType());
	}
}
