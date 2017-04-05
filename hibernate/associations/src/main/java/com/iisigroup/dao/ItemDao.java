package com.iisigroup.dao;

import java.util.List;

import com.iisigroup.domain.Item;

public interface ItemDao {
	public void insert(Item po);
	
	public void insert(Item... pos);

	public void update(Item po);

	public void delete(Long id);

	public Item findByPrimary(Long id);

	public List<Item> findAll();

	public long count();
}
