package com.iisigroup.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.iisigroup.config.AppConfig;
import com.iisigroup.config.WebAppConfig;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { WebAppConfig.class, AppConfig.class })
@Transactional
public class UserControllerTest {
	@Autowired
	protected WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUserPage() throws Exception {
		mockMvc.perform(get("/user").contentType(MediaType.TEXT_PLAIN)).andExpect(status().isOk())
				.andExpect(view().name("user"));
	}

	@Test
	public void testListUser() throws Exception {
		InputStream is = getClass().getClassLoader().getResourceAsStream("listUserRq.json");
		mockMvc.perform(post("/user/listUser").contentType(MediaType.APPLICATION_JSON).content(IOUtils.toByteArray(is)))
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.total").value(11)).andExpect(jsonPath("$.rows.length()").value(11));
	}

	@Test
	@Rollback
	public void testCreateUser() throws Exception {
		InputStream is = getClass().getClassLoader().getResourceAsStream("createUserRq.json");
		mockMvc.perform(
				post("/user/createUser").contentType(MediaType.APPLICATION_JSON).content(IOUtils.toByteArray(is)))
				.andExpect(status().isOk());
	}

	@Test
	@Rollback
	public void testUpdateUser() throws Exception {
		InputStream is = getClass().getClassLoader().getResourceAsStream("updateUserRq.json");
		mockMvc.perform(
				put("/user/updateUser").contentType(MediaType.APPLICATION_JSON).content(IOUtils.toByteArray(is)))
				.andExpect(status().isOk());
	}

	@Test
	@Rollback
	public void testRemoveUser() throws Exception {
		InputStream is = getClass().getClassLoader().getResourceAsStream("deleteUserRq.json");
		mockMvc.perform(
				delete("/user/deleteUser").contentType(MediaType.APPLICATION_JSON).content(IOUtils.toByteArray(is)))
				.andExpect(status().isOk());
	}

}
