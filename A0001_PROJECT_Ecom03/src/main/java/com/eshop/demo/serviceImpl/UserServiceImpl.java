package com.eshop.demo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.demo.dto.UserDto;
import com.eshop.demo.model.Role;
import com.eshop.demo.model.User;
import com.eshop.demo.payload.ResourceNotFoundException;
import com.eshop.demo.repo.UserRepo;
import com.eshop.demo.service.RoleService;
import com.eshop.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepo repo;
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	RoleService rservice;
	
	@Override
	public UserDto create(UserDto dto) {
		User u = mapper.map(dto, User.class);
		return mapper.map(repo.save(u), UserDto.class);
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
	public UserDto update(UserDto dto, Long id) {
		User u = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","ID",id));
		u.setName(dto.getName());
		u.setEmail(dto.getEmail());
		u.setPass(dto.getPass());
		u.setRole(mapper.map(dto.getRole(), Role.class));
		return mapper.map(repo.save(u), UserDto.class);
	}

	@Override
	public void destroy(Long id) {
		User u = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","ID",id));
		repo.delete(u);
	}

	@Override
	public UserDto retrive(Long id) {
		User u = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","ID",id));
		return mapper.map(u, UserDto.class);
	}

	@Override
	public List<UserDto> retriveByRole(Long id) {
	 	Role r = mapper.map(rservice.retrive(id), Role.class);
	 	List<User> ulist = repo.findByRole(r);
	 	List<UserDto> dtos = ulist.stream().map(u->{
	 		return mapper.map(u, UserDto.class);
	 	}).collect(Collectors.toList());
		return dtos;
	}

}
          