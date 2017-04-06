package com.iisigroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.iisigroup.domain.User;

public class JPAUserDao implements UserDao {
	private EntityManagerFactory entityManagerFactory;

	public JPAUserDao() {
		entityManagerFactory = Persistence.createEntityManagerFactory("jpademo");
	}

	@Override
	public void insert(User po) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(po);
			entityManager.getTransaction().commit();
		} catch (RuntimeException e) {
			entityManager.getTransaction().rollback();
		}
		entityManager.close();
	}

	@Override
	public void update(User po) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(po);
			entityManager.getTransaction().commit();
		} catch (RuntimeException e) {
			entityManager.getTransaction().rollback();
		}
	}

	@Override
	public void delete(Long id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			User user = entityManager.find(User.class, id);
			entityManager.remove(user);
			entityManager.getTransaction().commit();
		} catch (RuntimeException e) {
			entityManager.getTransaction().rollback();
		}
	}

	@Override
	public User findByPrimary(Long id) {
		User user = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			user = entityManager.find(User.class, id);
			entityManager.getTransaction().commit();
		} catch (RuntimeException e) {
			entityManager.getTransaction().rollback();
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		List<User> users = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Query query = entityManager.createQuery("from User");
			users = query.getResultList();
			entityManager.getTransaction().commit();
		} catch (RuntimeException e) {
			entityManager.getTransaction().rollback();
		}
		return users;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByExample(User user) {
		List<User> users = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Query query = entityManager.createQuery("from User where name=:name and age=:age");
			query.setParameter("name", user.getName());
			query.setParameter("age", user.getAge());
			users = query.getResultList();
			entityManager.getTransaction().commit();
		} catch (RuntimeException e) {
			entityManager.getTransaction().rollback();
		}
		return users;
	}

	@Override
	public long count() {
		long count = 0;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Query query = entityManager.createQuery("select count(*) from User");
			count = (long) query.getSingleResult();
			entityManager.getTransaction().commit();
		} catch (RuntimeException e) {
			entityManager.getTransaction().rollback();
		}
		return count;
	}

	@Override
	public double avgAge() {
		double avg = 0;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Query query = entityManager.createQuery("select avg(age) from User");
			avg = (double) query.getSingleResult();
			entityManager.getTransaction().commit();
		} catch (RuntimeException e) {
			entityManager.getTransaction().rollback();
		}
		return avg;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> groupByCountry() {
		List<Object[]> list = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Query query = entityManager
					.createQuery("select country, avg(age) from User group by country order by country");
			list = query.getResultList();
			entityManager.getTransaction().commit();
		} catch (RuntimeException e) {
			entityManager.getTransaction().rollback();
		}
		return list;
	}

}
