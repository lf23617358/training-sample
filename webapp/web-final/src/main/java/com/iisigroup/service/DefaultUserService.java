package com.iisigroup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iisigroup.dao.UserRepository;
import com.iisigroup.domain.User;
import com.iisigroup.dto.UserDto;
import com.iisigroup.utils.BeanUtils;

@Service
@Transactional
public class DefaultUserService implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public long insert(UserDto dto) {
		return userRepository.insert(BeanUtils.convertObj(dto, User.class));
	}

	@Override
	public void update(UserDto dto) {
		userRepository.update(BeanUtils.convertObj(dto, User.class));
	}

	@Override
	public void delete(Long id) {
		userRepository.delete(id);
	}

	@Override
	public void delete(Long[] ids) {
		userRepository.delete(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public UserDto findByPrimary(Long id) {
		return BeanUtils.convertObj(userRepository.findByPrimary(id), UserDto.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserDto> findAll() {
		return BeanUtils.convertList(userRepository.findAll(), UserDto.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserDto> findByExample(UserDto dto) {
		return BeanUtils.convertList(userRepository.findByExample(BeanUtils.convertObj(dto, User.class)),
				UserDto.class);
	}

	@Override
	@Transactional(readOnly = true)
	public long count() {
		return userRepository.count();
	}

}
