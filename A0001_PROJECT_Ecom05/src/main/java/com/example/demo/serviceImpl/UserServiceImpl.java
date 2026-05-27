package com.example.demo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.dto.RoleDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;

@Controller
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepo repo;
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	RoleService roleservice;
	
	@Override
	public UserDto create(UserDto dto) {
		User u = mapper.map(dto, User.class);
		User created = repo.save(u);
		return mapper.map(created, UserDto.class);
	}

	@Override
	public UserDto updated(UserDto dto, Long id) {
		User user = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("User", "ID", id));
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setPass(dto.getPass());
		user.setCreatedAt(dto.getCreatedAt());
		user.setActive(dto.isActive());
		user.setRole(mapper.map(dto.getRole(), Role.class));
		return mapper.map(repo.save(user), UserDto.class);
	}

	@Override
	public List<UserDto> list() {
		List<User> ulist = repo.findAll();
		List<UserDto> dtos = ulist.stream().map(u->{
			return mapper.map(u, UserDto.class);
		}).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public UserDto retrive(Long id) {
		User user = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("User", "ID", id));
		return mapper.map(user, UserDto.class);
	}

	@Override
	public void destroy(Long id) {
		User user = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("User", "ID", id));
		repo.delete(user);
	}

	@Override
	public List<UserDto> findByRole(Long rid) {
		RoleDto role = roleservice.retrive(rid);
		List<User> ulist = repo.findByRole(mapper.map(role, Role.class));
		List<UserDto> dtos = ulist.stream().map(u->{
			return mapper.map(u, UserDto.class);
		}).collect(Collectors.toList());
		return dtos;
	}

}
