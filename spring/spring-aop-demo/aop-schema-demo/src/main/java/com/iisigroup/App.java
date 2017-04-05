package com.iisigroup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iisigroup.service.IUserService;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		/** Init ApplicationContext by Java **/
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		/** get bean **/
		IUserService userService = context.getBean(IUserService.class);
		userService.getUser("Miku");
	}
}
