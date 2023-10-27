package com.training.stsdemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("elecdisc")
@Component
public class ElectronicDiscount implements Discount{

	@Override
	public int getDiscount() {
		return 20;
	}

}
