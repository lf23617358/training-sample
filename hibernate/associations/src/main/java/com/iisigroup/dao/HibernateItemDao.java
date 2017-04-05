package com.iisigroup.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.iisigroup.domain.Item;
import com.iisigroup.utils.HibernateUtil;

public class HibernateItemDao implements ItemDao {
	private SessionFactory sessionFactory;

	public HibernateItemDao() {
		sessionFactory = HibernateUtil.buildSessionFactory();
	}

	@Override
	public void insert(Item po) {
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
	public void insert(Item... pos) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			for (Item po : pos){
				session.save(po);
			}
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

	@Override
	public void update(Item po) {
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
			Item Item = session.get(Item.class, id);
			session.delete(Item);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
		}
	}

	@Override
	public Item findByPrimary(Long id) {
		Item Item = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			Item = session.get(Item.class, id);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
		}
		return Item;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> findAll() {
		List<Item> Items = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from Item");
			Items = (List<Item>) query.list();
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
		}
		return Items;
	}

	@Override
	public long count() {
		long count = 0;
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("select count(*) from Item"); // 前面加select
			count = (Long) query.list().get(0); // 因為是計算count所以只取出第一筆
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
		}
		return count;
	}

}
