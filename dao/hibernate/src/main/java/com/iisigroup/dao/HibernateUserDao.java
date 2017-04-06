package com.iisigroup.dao;

import java.util.List;

import javax.persistence.CascadeType;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.iisigroup.domain.User;

public class HibernateUserDao implements UserDao {
	// A SessionFactory is set up once for an application!
	private SessionFactory sessionFactory;

	public HibernateUserDao() {
		// hibernate5
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // configures
				.build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had
			// trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy(registry);
		}

		// hibernate4
		// try {
		// // Create the SessionFactory from hibernate.cfg.xml
		// sessionFactory = new
		// Configuration().configure().buildSessionFactory();
		// } catch (Throwable ex) {
		// // Make sure you log the exception, as it might be swallowed
		// System.err.println("Initial SessionFactory creation failed." + ex);
		// throw new ExceptionInInitializerError(ex);
		// }
	}

	@Override
	public void insert(User po) {
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
	public void update(User po) {
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
			User user = new User();
			user.setId(id);
			session.delete(user);
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
	public List<User> findAll() {
		List<User> users = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from User");
			users = (List<User>) query.list();
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
		}
		return users;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByExample(User user) {
		List<User> users = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from User where name=:name and age=:age");
			query.setProperties(user);
			query.setProperties(user);
			users = (List<User>) query.list();
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
		}
		return users;
	}

	@Override
	public long count() {
		long count = 0;
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("select count(*) from User"); // 前面加select
			count = (Long) query.list().get(0); // 因為是計算count所以只取出第一筆
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
		}
		return count;
	}

	@Override
	public double avgAge() {
		double avg = 0;
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("select avg(age) from User");
			avg = (Double) query.list().get(0); // 因為是計算avg所以只取出第一筆
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
		}
		return avg;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> groupByCountry() {
		List<Object[]> list = null;
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery("select country, avg(age) from User group by country order by country");
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
		}
		return list;
	}

}
