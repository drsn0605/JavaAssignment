package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDto;

public interface UserService {

	public UserDto create(UserDto dto);
	public List<UserDto> list();
	public UserDto update(UserDto dto, Long id);
	public void destroy(Long id);
	public UserDto retrive(Long id);
	public List<UserDto> findByRole(Long rid);
}
