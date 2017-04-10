package com.iisigroup.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iisigroup.domain.User;

@Repository
@Transactional
public class HibernateUserDao implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insert(User po) {
		sessionFactory.getCurrentSession().save(po);
	}

	@Override
	public void update(User po) {
		sessionFactory.getCurrentSession().update(po);
	}

	@Override
	public void delete(Long id) {
		User user = new User();
		user.setId(id);
		sessionFactory.getCurrentSession().delete(user);
	}

	@Transactional(readOnly = true)
	@Override
	public User findByPrimary(Long id) {
		return sessionFactory.getCurrentSession().get(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<User> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}
	
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findByExample(User user) {
		Query query = sessionFactory.getCurrentSession().createQuery("from User where name=:name and age=:age");
		query.setProperties(user);
		query.setProperties(user);
		return query.list();
	}

	@Transactional(readOnly = true)
	@Override
	public long count() {
		return (long) sessionFactory.getCurrentSession().createQuery("select count(*) from User").list().get(0); // 前面加select
	}
	
	@Transactional(readOnly = true)
	@Override
	public double avgAge() {
		return (double) sessionFactory.getCurrentSession().createQuery("select avg(age) from User").list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Object[]> groupByCountry() {
		return sessionFactory.getCurrentSession()
				.createQuery("select country, avg(age) from User group by country order by country").list();
	}

}
