package com.eshop.demo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.demo.dto.UserDto;
import com.eshop.demo.model.User;
import com.eshop.demo.repo.UserRepo;
import com.eshop.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepo repo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public UserDto create(UserDto dto) {
		User u = mapper.map(dto, User.class);
		User created = repo.save(u);
		return mapper.map(created, UserDto.class);
	}

	@Override
	public List<UserDto> list() {
		List<User> ulist = repo.findAll();
		List<UserDto> dtos = ulist.stream().map(u->{
			return mapper.map(u, UserDto.class);
		}).collect(Collectors.toList());
		return dtos;
	}

}
