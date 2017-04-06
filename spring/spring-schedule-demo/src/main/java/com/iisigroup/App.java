package com.iisigroup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.iisigroup.config.AppConfig;

public class App {
	public static void main(String[] args) {
		@SuppressWarnings({ "resource", "unused" })
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	}
}
