package com.iisigroup.service;

import com.iisigroup.domain.User;

public class HelloService implements IHelloService {
	private User user;

	public HelloService(User user) {
		super();
		this.user = user;
	}

	@Override
	public void sayHello() {
		System.out.println("Hello!!!" + user.getFirstName() + " " + user.getLastName() + "!!!!");
	}

}
