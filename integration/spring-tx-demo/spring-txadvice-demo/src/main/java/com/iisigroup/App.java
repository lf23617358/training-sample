package com.iisigroup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iisigroup.domain.User;
import com.iisigroup.service.UserService;

public class App {
	public static void main(String[] args) {
		/** Init ApplicationContext by xml **/
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		/** get bean **/
		UserService userService = context.getBean(UserService.class);
		userService.insert(new User());
	}
}
