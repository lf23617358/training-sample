package com.iisigroup.service;

import java.util.List;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.transaction.annotation.Transactional;

import com.iisigroup.config.AppConfig;
import com.iisigroup.dto.UserDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
@Transactional
public class DefaultUserServiceTest {
	@Autowired
	private UserService userService;

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Rollback
	public void testInsert() {
		UserDto userDto = new UserDto();
		// userDto.setId(3l);
		userDto.setName("testuser3");
		userDto.setAge(30);
		userDto.setCountry("日本");
		long id = userService.insert(userDto);
		UserDto newUserDto = userService.findByPrimary(id);
		assertEquals("testuser3", newUserDto.getName());
		assertEquals(Integer.valueOf(30), newUserDto.getAge());
		assertEquals("日本", newUserDto.getCountry());
	}

	@Test
	@Rollback
	public void testUpdate() {
		UserDto userDto = userService.findByPrimary(1l);
		userDto.setAge(30);
		userService.update(userDto);
		UserDto newUserDto = userService.findByPrimary(1l);
		assertEquals(Integer.valueOf(30), newUserDto.getAge());
	}

	@Test
	@Rollback
	public void testDelete() {
		userService.delete(1l);
		UserDto userDto = userService.findByPrimary(1l);
		assertNull(userDto);
	}

	@Test
	public void testFindByPrimary() {
		UserDto userDto = userService.findByPrimary(1l);
		assertEquals(Long.valueOf(1l), userDto.getId());
		assertEquals("testuser1", userDto.getName());
		assertEquals(Integer.valueOf(18), userDto.getAge());
		assertEquals("台灣", userDto.getCountry());
	}

	@Test
	public void testFindAllByExample() {
		UserDto userDto = new UserDto();
		userDto.setName("testuser1");
		userDto.setAge(18);
		List<UserDto> userDtos = userService.findByExample(userDto);
		for (UserDto u : userDtos) {
			System.out.print(u.getName() + " " + u.getAge());
		}
		assertEquals("testuser1", userDtos.get(0).getName());
		assertEquals(Integer.valueOf(18), userDtos.get(0).getAge());
		assertEquals("台灣", userDtos.get(0).getCountry());
	}

//	@Test
//	public void testFindAllByPage() {
//		UserDto userDto = new UserDto();
//		Page<UserDto> userDtos = userService.findByPage(userDto, 1, 5);
//		for (UserDto u : userDtos.getData()) {
//			System.out.print(u.getName() + " " + u.getAge());
//		}
//		Assert.assertEquals("testuser2", userDtos.getData().get(0).getName());
//	}

	@Test
	public void testFindAll() {
		List<UserDto> userDtos = userService.findAll();
		assertEquals(JdbcTestUtils.countRowsInTable(jdbcTemplate, "user"), userDtos.size());
		assertEquals("testuser1", userDtos.get(0).getName());
		assertEquals(Integer.valueOf(18), userDtos.get(0).getAge());
		assertEquals("台灣", userDtos.get(0).getCountry());
		assertEquals("testuser2", userDtos.get(1).getName());
		assertEquals(Integer.valueOf(22), userDtos.get(1).getAge());
		assertEquals("美國", userDtos.get(1).getCountry());
	}

	@Test
	public void testCount() {
		long count = userService.count();
		assertEquals(JdbcTestUtils.countRowsInTable(jdbcTemplate, "user"), count);
	}

}
