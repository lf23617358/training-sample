package com.iisigroup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iisigroup.service.HelloService;
import com.iisigroup.service.IHelloService;

public class App {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		IHelloService helloService = context.getBean(HelloService.class);
		helloService.sayHello();
	}
}
