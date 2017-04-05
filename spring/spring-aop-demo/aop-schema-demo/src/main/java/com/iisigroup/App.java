package com.iisigroup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iisigroup.service.IUserService;

public class App {
	public static void main(String[] args) {
		/** Init ApplicationContext by xml config **/
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		/** get bean **/
		IUserService userService = context.getBean(IUserService.class);
		userService.getUser("Miku");
	}
}
