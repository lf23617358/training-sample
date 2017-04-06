package com.iisigroup;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.iisigroup.bean.ArithmeticBean;
import com.iisigroup.bean.Customer;
import com.iisigroup.bean.ListAndMapBean;
import com.iisigroup.bean.LogicalBean;
import com.iisigroup.bean.RegexBean;
import com.iisigroup.bean.RelationalBean;
import com.iisigroup.bean.TernaryBean;
import com.iisigroup.config.AppConfig;

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
	public void testBeanRefrence() {
		Customer obj = (Customer) context.getBean("customerBean");
		// Get Bean Properties
		Assert.assertEquals("itemA", obj.getItemName());
		// Get Bean
		Assert.assertEquals("itemA", obj.getItem().getName());
		// Method Invocation
		Assert.assertEquals(99.99, obj.getAmount(), 0);
	}

	@Test
	public void testArithmeticBean() {
		ArithmeticBean obj = (ArithmeticBean) context.getBean("arithmeticBean");
		// add
		Assert.assertEquals(20, obj.getAdd());
		Assert.assertEquals("String1 String2", obj.getAddString());
		// sub
		Assert.assertEquals(19, obj.getSubtract());
		// mul
		Assert.assertEquals(20, obj.getMultiply());
		// div
		Assert.assertEquals(18, obj.getDivide(), 0);
		Assert.assertEquals(18, obj.getDivideAlphabetic(), 0);
		// mod
		Assert.assertEquals(7, obj.getModulo());
		Assert.assertEquals(7, obj.getModuloAlphabetic());
		// pow
		Assert.assertEquals(512, obj.getPowerOf());
		// brackets
		Assert.assertEquals(17, obj.getBrackets());

	}

	@Test
	public void testRelationalBean() {
		RelationalBean obj = (RelationalBean) context.getBean("relationalBean");
		// eq
		Assert.assertEquals(true, obj.isEqual());
		Assert.assertEquals(true, obj.isEqualAlphabetic());
		// ne
		Assert.assertEquals(false, obj.isNotEqual());
		Assert.assertEquals(false, obj.isNotEqualAlphabetic());
		// lt
		Assert.assertEquals(false, obj.isLessThan());
		Assert.assertEquals(false, obj.isLessThanAlphabetic());
		// le
		Assert.assertEquals(true, obj.isLessThanOrEqual());
		Assert.assertEquals(true, obj.isLessThanOrEqualAlphabetic());
		// gt
		Assert.assertEquals(false, obj.isGreaterThan());
		Assert.assertEquals(false, obj.isGreaterThanAlphabetic());
		// ge
		Assert.assertEquals(true, obj.isGreaterThanOrEqual());
		Assert.assertEquals(true, obj.isGreaterThanOrEqualAlphabetic());

	}

	@Test
	public void testLogicalBean() {
		LogicalBean obj = (LogicalBean) context.getBean("logicalBean");
		// and
		Assert.assertEquals(true, obj.isAnd());
		Assert.assertEquals(true, obj.isAndAlphabetic());
		// or
		Assert.assertEquals(true, obj.isOr());
		Assert.assertEquals(true, obj.isOrAlphabetic());
		// not
		Assert.assertEquals(false, obj.isNot());
		Assert.assertEquals(false, obj.isNotAlphabetic());

	}

	@Test
	public void testTernaryBean() {
		TernaryBean obj = (TernaryBean) context.getBean("ternaryBean");
		// ternary
		Assert.assertEquals("a", obj.getTernary());

	}

	@Test
	public void testRegexBean() {
		RegexBean obj = (RegexBean) context.getBean("regexBean");
		// matches
		Assert.assertEquals(true, obj.isValidNumeric());
		Assert.assertEquals(false, obj.isInvalidNumeric());
		Assert.assertEquals(true, obj.isValidAlphabetic());
		Assert.assertEquals(false, obj.isInvalidAlphabetic());

	}

	@Test
	public void testListAndMapBean() {
		ListAndMapBean obj = (ListAndMapBean) context.getBean("listAndMapBean");
		// map
		Assert.assertEquals(35000, obj.getJohnSalary());
		Assert.assertEquals(14000, obj.getGeorgeSalary());
		Assert.assertEquals(47000, obj.getSusieSalary());
		// list
		Assert.assertEquals("John", obj.getFirstWorker());
		Assert.assertEquals("George", obj.getLastWorker());
		// size
		Assert.assertEquals(4, obj.getNumberOfWorkers());

	}

}
