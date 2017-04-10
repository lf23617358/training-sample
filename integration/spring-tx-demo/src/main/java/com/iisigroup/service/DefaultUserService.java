package com.iisigroup.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iisigroup.domain.User;

@Service
public class DefaultUserService implements UserService {

	@Override
	public void insert(User po) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(User po) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(Long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public User findByPrimary(Long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<User> findAll() {
		throw new UnsupportedOperationException();
	}

}
