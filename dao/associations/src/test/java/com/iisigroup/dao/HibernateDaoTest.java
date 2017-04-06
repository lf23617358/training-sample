package com.iisigroup.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.iisigroup.domain.Item;
import com.iisigroup.domain.Order;

public class HibernateDaoTest {
	private EntityManager entityManager;

	@Before
	public void setUp() throws Exception {
		entityManager = Persistence.createEntityManagerFactory("jpademo").createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Order order = new Order();
			order.setName("order1");

			Item item1 = new Item();
			item1.setName("item1_order1");
			item1.setOrder(order);

			Item item2 = new Item();
			item2.setName("item2_order1");
			item2.setOrder(order);

			List<Item> items = new ArrayList<Item>();
			items.add(item1);
			items.add(item2);
			order.setItems(items);
			entityManager.persist(order);
			entityManager.persist(item1);
			entityManager.persist(item2);
			// session.save(item1);
			// session.save(item2);
			entityManager.getTransaction().commit();
			boolean contains = entityManager.contains(order);
			System.out.println(contains);
		} catch (RuntimeException e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		entityManager.clear();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addTest() throws Exception {
		Order order = entityManager.find(Order.class, 1);
		// System.out.println(order.getName());
		// System.out.println(order.getItems());
		// entityManager.getTransaction().begin();
		System.out.println("find:" + entityManager.contains(order));
		order.setName("test");
		order.getItems().get(0).setName("test");
		// entityManager.getTransaction().commit();
		// Item item = entityManager.find(Item.class, 1);
		// item.setName("test");
		entityManager.clear();
		System.out.println(entityManager.contains(order));
		Order order1 = entityManager.merge(order);
		entityManager.refresh(order1);
		System.out.println(order1.getName());
	}

}
