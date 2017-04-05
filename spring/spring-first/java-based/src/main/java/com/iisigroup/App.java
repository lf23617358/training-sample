package com.iisigroup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.iisigroup.config.AppConfig;
import com.iisigroup.service.HelloService;
import com.iisigroup.service.IHelloService;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		IHelloService helloService = context.getBean(HelloService.class);
		helloService.sayHello();
	}
}
