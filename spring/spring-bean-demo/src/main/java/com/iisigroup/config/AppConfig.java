package com.iisigroup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.iisigroup.service.ExampleBean;
import com.iisigroup.service.ExampleBeanPostProcessor;
import com.iisigroup.service.ExampleScopeBean;

@Configuration
@ComponentScan(basePackages = "com.iisigroup")
public class AppConfig {

	@Bean(initMethod = "customInit", destroyMethod = "customDestroy")
	public ExampleBean exampleBean() {
		return new ExampleBean();
	}

	@Bean
	public ExampleBeanPostProcessor exampleBeanPostProcessor() {
		return new ExampleBeanPostProcessor();
	}

	@Bean(name = "singletonBean")
	public ExampleScopeBean singletonBean() {
		ExampleScopeBean exampleScopeBean = new ExampleScopeBean();
		exampleScopeBean.setMessage("hello");
		return exampleScopeBean;
	}

	@Scope("prototype")
	@Bean(name = "prototypeBean")
	public ExampleScopeBean prototypeBean() {
		ExampleScopeBean exampleScopeBean = new ExampleScopeBean();
		exampleScopeBean.setMessage("hello");
		return exampleScopeBean;
	}

}
