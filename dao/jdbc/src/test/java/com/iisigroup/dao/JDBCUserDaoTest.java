package com.iisigroup.dao;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.iisigroup.domain.User;
import com.iisigroup.utils.InitDbUtils;

public class JDBCUserDaoTest {
	private UserDao userDao;

	@Before
	public void setUp() throws Exception {
		userDao = new JDBCUserDao();
		InitDbUtils.initDDL();
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
		userDao.insert(user);
		User newUser = userDao.findByPrimary(3l);
		Assert.assertEquals("testuser3", newUser.getName());
		Assert.assertEquals(Integer.valueOf(30), newUser.getAge());
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
	}

	@Test
	public void testFindAll() {
		List<User> users = userDao.findAll();
		Assert.assertEquals("testuser1", users.get(0).getName());
		Assert.assertEquals(Integer.valueOf(18), users.get(0).getAge());
		Assert.assertEquals("testuser2", users.get(1).getName());
		Assert.assertEquals(Integer.valueOf(22), users.get(1).getAge());
	}

}
