package com.iisigroup;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.iisigroup.config.AppConfig;
import com.iisigroup.service.ExampleScopeBean;

public class BeanTest {
	private ApplicationContext context;

	@Before
	public void setUp() throws Exception {
		context = new AnnotationConfigApplicationContext(AppConfig.class);
	}

	@After
	public void tearDown() throws Exception {
		((AbstractApplicationContext) context).close();
	}

	@Test
	public void testScopeBean() {
		ExampleScopeBean singletonBean1 = context.getBean("singletonBean", ExampleScopeBean.class);
		ExampleScopeBean singletonBean2 = context.getBean("singletonBean", ExampleScopeBean.class);
		ExampleScopeBean prototypeBean1 = context.getBean("prototypeBean", ExampleScopeBean.class);
		ExampleScopeBean prototypeBean2 = context.getBean("prototypeBean", ExampleScopeBean.class);

		Assert.assertEquals(singletonBean1, singletonBean2);
		Assert.assertNotEquals(prototypeBean1, prototypeBean2);

		//test singleton
		// check message
		Assert.assertEquals(singletonBean1.getMessage(), singletonBean2.getMessage());
		// update message
		singletonBean1.setMessage("new hello");
		// recheck message
		Assert.assertEquals(singletonBean1.getMessage(), singletonBean2.getMessage());

		//test prototype
		// check message
		Assert.assertEquals(prototypeBean1.getMessage(), prototypeBean2.getMessage());
		// update message
		prototypeBean1.setMessage("new hello");
		// recheck message
		Assert.assertNotEquals(prototypeBean1.getMessage(), prototypeBean2.getMessage());
	}
}
