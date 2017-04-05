package com.iisigroup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.iisigroup.config.AppConfig;
import com.iisigroup.service.IUserService;

public class App {
	public static void main(String[] args) {
		/** Init ApplicationContext by Java **/
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		/** get bean **/
		IUserService userService = context.getBean(IUserService.class);
		userService.getUser("Miku");
	}
}
