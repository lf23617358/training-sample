package com.iisigroup.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import com.iisigroup.domain.User;

@Repository
public class JPAUserRepository implements UserRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public long insert(User po) {
		entityManager.persist(po);
		return po.getId();
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
	public void delete(Long[] ids) {
		Query query = entityManager.createQuery("delete from User WHERE id in :ids");
		query.setParameter("ids", Arrays.asList(ids));
		query.executeUpdate();
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

	@Override
	public List<User> findByExample(User po) {
		return entityManager.createQuery(getQuery(po)).getResultList();
	}

	@Override
	public long count() {
		return (long) entityManager.createQuery("select count(*) from User").getSingleResult();
	}

	private CriteriaQuery<User> getQuery(User po) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> query = cb.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.select(root);
		query.where(cb.and(getPredicates(cb, root, po)));
		return query;
	}

	// private CriteriaQuery<Long> getQueryForCount(User po) {
	// CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	// CriteriaQuery<Long> query = cb.createQuery(Long.class);
	// Root<User> root = query.from(User.class);
	// query.select(cb.count(root));
	// query.where(cb.and(getPredicates(cb, root, po)));
	// return query;
	// }

	private Predicate[] getPredicates(CriteriaBuilder cb, Root<User> root, User po) {
		List<Predicate> predicates = new ArrayList<>();
		if (!ObjectUtils.isEmpty(po.getName()))
			predicates.add(cb.equal(root.get("name"), po.getName()));
		if (po.getAge() != null && po.getAge() >= 0)
			predicates.add(cb.equal(root.get("age"), po.getAge()));
		if (!ObjectUtils.isEmpty(po.getCountry()))
			predicates.add(cb.equal(root.get("country"), po.getCountry()));
		return predicates.toArray(new Predicate[0]);
	}

}
