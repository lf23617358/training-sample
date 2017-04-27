package com.iisigroup.service;

import java.util.List;

import com.iisigroup.dto.UserDto;

public interface UserService {
	public long insert(UserDto dto);

	public void update(UserDto dto);

	public void delete(Long id);

	public void delete(Long[] ids);

	public UserDto findByPrimary(Long id);

	public List<UserDto> findAll();

	public List<UserDto> findByExample(UserDto dto);

	public long count();

}
