package com.iisigroup.dao;

import java.util.List;

import org.h2.engine.User;

import com.iisigroup.domain.Order;

public interface OrderDao {
	public void insert(Order po);

	public void update(Order po);

	public void delete(Long id);

	public User findByPrimary(Long id);

	public List<Order> findAll();

	public long count();

}
