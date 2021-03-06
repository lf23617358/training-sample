package com.iisigroup.dao;

import java.util.List;

import com.iisigroup.domain.User;

public interface UserRepository {
	public long insert(User po);

	public void update(User po);

	public void delete(Long id);

	public void delete(Long[] ids);

	public User findByPrimary(Long id);

	public List<User> findAll();

	public List<User> findByExample(User po);

	public long count();

}
