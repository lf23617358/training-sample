package com.iisigroup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.iisigroup.domain.User;
import com.iisigroup.service.HelloService;
import com.iisigroup.service.IHelloService;

@Configuration
public class AppConfig {
	@Bean
	public User demoUser() {
		User user = new User();
		user.setFirstName("Hatsune");
		user.setLastName("Miku");
		return user;
	}

	@Bean
	public IHelloService helloService() {
		return new HelloService(demoUser());
	}
}
