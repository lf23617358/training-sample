package com.iisigroup.dao;

import java.util.List;

import org.h2.engine.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.iisigroup.domain.Order;
import com.iisigroup.utils.HibernateUtil;

public class HibernateOrderDao implements OrderDao {
	private SessionFactory sessionFactory;

	public HibernateOrderDao() {
		sessionFactory = HibernateUtil.buildSessionFactory();
	}

	@Override
	public void insert(Order po) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(po);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
		}
	}

	@Override
	public void update(Order po) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			session.update(po);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
		}
	}

	@Override
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			Order order = session.get(Order.class, id);
			session.delete(order);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
		}
	}

	@Override
	public User findByPrimary(Long id) {
		User user = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			user = session.get(User.class, id);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findAll() {
		List<Order> orders = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from Order");
			orders = (List<Order>) query.list();
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
		}
		return orders;
	}

	@Override
	public long count() {
		long count = 0;
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("select count(*) from Order"); // 前面加select
			count = (Long) query.list().get(0); // 因為是計算count所以只取出第一筆
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
		}
		return count;
	}

}
