package com.iisigroup.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iisigroup.domain.User;

@Service
@Transactional
public class TxDefaultUserService implements UserService {

	@Override
	@Transactional
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
	@Transactional(readOnly = true)
	public User findByPrimary(Long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		throw new UnsupportedOperationException();
	}

}
