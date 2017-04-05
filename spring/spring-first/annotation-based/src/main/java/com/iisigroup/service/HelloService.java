package com.iisigroup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iisigroup.domain.User;

@Service
public class HelloService implements IHelloService {
	@Autowired(required = true)
	private User user;

	@Override
	public void sayHello() {
		System.out.println("Hello!!!" + user.getFirstName() + " " + user.getLastName() + "!!!!");
	}

}
