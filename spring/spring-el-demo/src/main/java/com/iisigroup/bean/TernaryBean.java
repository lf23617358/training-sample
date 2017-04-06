package com.iisigroup.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TernaryBean {
	@Value("#{2 > 1 ? 'a' : 'b'}") // Will inject "a"
	private String ternary;

	public String getTernary() {
		return ternary;
	}

	public void setTernary(String ternary) {
		this.ternary = ternary;
	}

}
