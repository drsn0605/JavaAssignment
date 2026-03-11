package com.eshop.demo.service;

import java.util.List;

import com.eshop.demo.dto.UserDto;

public interface UserService {
	public UserDto create(UserDto dto);
	public List<UserDto> list();
	public UserDto update(UserDto dto, Long uid);
	public void destroy(Long id);
	public UserDto retrive(Long id);
	public List<UserDto> retriveByRole(Long id);
	
}
