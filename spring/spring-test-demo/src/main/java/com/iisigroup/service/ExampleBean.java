package com.iisigroup.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class ExampleBean implements InitializingBean, DisposableBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("inteface init");
	}

	public void customInit() {
		System.out.println("custom init");
	}

	@PostConstruct
	public void annotationInit() {
		System.out.println("annotation init");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("inteface destroy");
	}

	public void customDestroy() {
		System.out.println("custom destroy");
	}

	@PreDestroy
	public void annotationDestroy() {
		System.out.println("annotation destroy");
	}

}
