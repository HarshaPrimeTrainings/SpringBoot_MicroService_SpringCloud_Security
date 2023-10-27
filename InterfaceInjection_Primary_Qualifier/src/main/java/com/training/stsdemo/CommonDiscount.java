package com.training.stsdemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Qualifier("cmndisc")
@Component
public class CommonDiscount implements Discount{

	@Override
	public int getDiscount() {
		return 10;
	}
	
}
