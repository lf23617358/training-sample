package com.iisigroup.dao;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.iisigroup.domain.User;
import com.iisigroup.utils.InitDbUtils;

public class JPAUserDaoTest {
	private UserDao userDao;

	@Before
	public void setUp() throws Exception {
		userDao = new JPAUserDao();
		InitDbUtils.initDML();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsert() {
		User user = new User();
		user.setId(3l);
		user.setName("testuser3");
		user.setAge(30);
		user.setCountry("日本");
		userDao.insert(user);
		User newUser = userDao.findByPrimary(3l);
		Assert.assertEquals("testuser3", newUser.getName());
		Assert.assertEquals(Integer.valueOf(30), newUser.getAge());
		Assert.assertEquals("日本", newUser.getCountry());
	}

	@Test
	public void testUpdate() {
		User user = userDao.findByPrimary(1l);
		user.setAge(30);
		userDao.update(user);
		User newUser = userDao.findByPrimary(1l);
		Assert.assertEquals(Integer.valueOf(30), newUser.getAge());
	}

	@Test
	public void testDelete() {
		List<User> users = userDao.findAll();
		Assert.assertEquals(2, users.size());
		userDao.delete(1l);
		users = userDao.findAll();
		Assert.assertEquals(1, users.size());
	}

	@Test
	public void testFindByPrimary() {
		User user = userDao.findByPrimary(1l);
		Assert.assertEquals(Long.valueOf(1l), user.getId());
		Assert.assertEquals("testuser1", user.getName());
		Assert.assertEquals(Integer.valueOf(18), user.getAge());
		Assert.assertEquals("台灣", user.getCountry());
	}

	@Test
	public void testFindAllByExample() {
		User user = new User();
		user.setName("testuser1");
		user.setAge(18);
		List<User> users = userDao.findByExample(user);
		for (User u : users) {
			System.out.print(u.getName() + " " + u.getAge());
		}
		Assert.assertEquals("testuser1", users.get(0).getName());
		Assert.assertEquals(Integer.valueOf(18), users.get(0).getAge());
		Assert.assertEquals("台灣", users.get(0).getCountry());
	}

	@Test
	public void testFindAll() {
		List<User> users = userDao.findAll();
		Assert.assertEquals(2, users.size());
		Assert.assertEquals("testuser1", users.get(0).getName());
		Assert.assertEquals(Integer.valueOf(18), users.get(0).getAge());
		Assert.assertEquals("台灣", users.get(0).getCountry());
		Assert.assertEquals("testuser2", users.get(1).getName());
		Assert.assertEquals(Integer.valueOf(22), users.get(1).getAge());
		Assert.assertEquals("美國", users.get(1).getCountry());
	}

	@Test
	public void testCount() {
		long count = userDao.count();
		Assert.assertEquals(2, count);
	}

	@Test
	public void testAvgAge() {
		double avgAge = userDao.avgAge();
		Assert.assertEquals(20, avgAge, 0);
	}

	@Test
	public void testGroupByCountry() {
		List<Object[]> list = userDao.groupByCountry();
		Assert.assertEquals("台灣", list.get(0)[0]);
		Assert.assertEquals(18, (double) list.get(0)[1], 0);
		Assert.assertEquals("美國", list.get(1)[0]);
		Assert.assertEquals(22, (double) list.get(1)[1], 0);
	}
}
