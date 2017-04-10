package com.iisigroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iisigroup.domain.User;

@Repository
@Transactional
public class JPAUserDao implements UserDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insert(User po) {
		entityManager.persist(po);
	}

	@Override
	public void update(User po) {
		entityManager.merge(po);
	}

	@Override
	public void delete(Long id) {
		User user = entityManager.find(User.class, id);
		entityManager.remove(user);
	}

	@Override
	public User findByPrimary(Long id) {
		return entityManager.find(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		return entityManager.createQuery("from User").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByExample(User user) {
		List<User> users = null;
		Query query = entityManager.createQuery("from User where name=:name and age=:age");
		query.setParameter("name", user.getName());
		query.setParameter("age", user.getAge());
		users = query.getResultList();
		return users;
	}

	@Override
	public long count() {
		return (long) entityManager.createQuery("select count(*) from User").getSingleResult();
	}

	@Override
	public double avgAge() {
		return (double) entityManager.createQuery("select avg(age) from User").getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> groupByCountry() {
		return entityManager.createQuery("select country, avg(age) from User group by country order by country")
				.getResultList();
	}

}
