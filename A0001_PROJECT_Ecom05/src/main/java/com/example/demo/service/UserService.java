package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDto;

public interface UserService {

	public UserDto create(UserDto dto);
	public UserDto updated(UserDto dto, Long id);
	public List<UserDto> list();
	public UserDto retrive(Long id);
	public void destroy(Long id);
	public List<UserDto> findByRole(Long rid);
}
