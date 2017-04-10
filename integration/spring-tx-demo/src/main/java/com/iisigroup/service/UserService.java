package com.iisigroup.service;

import java.util.List;

import com.iisigroup.domain.User;

public interface UserService {
	public void insert(User po);

	public void update(User po);

	public void delete(Long id);

	public User findByPrimary(Long id);

	public List<User> findAll();
}
