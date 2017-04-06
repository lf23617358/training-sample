package com.iisigroup.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class ExampleBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof ExampleBean)
			System.out.println("after init " + beanName + " by BeanPostProcessor");
		return bean;
	}
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof ExampleBean)
			System.out.println("before init " + beanName + " by BeanPostProcessor");
		return bean;
	}

}
