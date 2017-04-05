package com.iisigroup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.iisigroup.domain.User;

@Configuration
@ComponentScan(basePackages = "com.iisigroup")
public class AppConfig {
	@Bean
	public User demoUser() {
		User user = new User();
		user.setFirstName("Hatsune");
		user.setLastName("Miku");
		return user;
	}
}
