package com.iisigroup.service;

import org.springframework.stereotype.Service;

import com.iisigroup.domain.User;

@Service
public class UserService implements IUserService {
	@Override
	public User getUser(String name) {
		User user = new User();
		user.setName(name);
		user.setAge(18);
		return user;
	}

}
