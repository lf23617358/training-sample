package com.iisigroup.dao;

import java.util.List;

import com.iisigroup.domain.User;

public interface UserDao {
	public void insert(User po);

	public void update(User po);

	public void delete(Long id);

	public User findByPrimary(Long id);

	public List<User> findAll();

	public List<User> findByExample(User user);
	
	public long count();
	
	public double avgAge();
	
	public List<Object[]> groupByCountry();

}
