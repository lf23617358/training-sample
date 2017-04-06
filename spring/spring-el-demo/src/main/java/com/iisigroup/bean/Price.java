package com.iisigroup.bean;

import org.springframework.stereotype.Component;

@Component("priceBean")
public class Price {

	public double getSpecialPrice() {
		return 99.99;
	}

}