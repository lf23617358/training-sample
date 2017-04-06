package com.iisigroup;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iisigroup.config.AppConfig;
import com.iisigroup.service.ExampleScopeBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class BeanTest {
	@Autowired
	@Qualifier("singletonBean")
	private ExampleScopeBean singletonBean1;
	@Autowired
	@Qualifier("singletonBean")
	private ExampleScopeBean singletonBean2;
	@Autowired
	@Qualifier("prototypeBean")
	private ExampleScopeBean prototypeBean1;
	@Autowired
	@Qualifier("prototypeBean")
	private ExampleScopeBean prototypeBean2;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testScopeBean() {
		Assert.assertEquals(singletonBean1, singletonBean2);
		Assert.assertNotEquals(prototypeBean1, prototypeBean2);

		// test singleton
		// check message
		Assert.assertEquals(singletonBean1.getMessage(), singletonBean2.getMessage());
		// update message
		singletonBean1.setMessage("new hello");
		// recheck message
		Assert.assertEquals(singletonBean1.getMessage(), singletonBean2.getMessage());

		// test prototype
		// check message
		Assert.assertEquals(prototypeBean1.getMessage(), prototypeBean2.getMessage());
		// update message
		prototypeBean1.setMessage("new hello");
		// recheck message
		Assert.assertNotEquals(prototypeBean1.getMessage(), prototypeBean2.getMessage());
	}
}
