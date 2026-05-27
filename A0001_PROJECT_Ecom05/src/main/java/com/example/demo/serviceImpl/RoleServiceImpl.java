package com.example.demo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RoleDto;
import com.example.demo.model.Role;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.RoleRepo;
import com.example.demo.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepo repo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public RoleDto create(RoleDto dto) {
		Role role = mapper.map(dto, Role.class);
		Role created = repo.save(role);
		return mapper.map(created, RoleDto.class);
	}

	@Override
	public List<RoleDto> list() {
		List<Role> rlist = repo.findAll();
		List<RoleDto> dtos = rlist.stream().map(r->{
			return mapper.map(r, RoleDto.class);
		}).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public RoleDto update(RoleDto dto, Long id) {
		Role r = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Role", "ID", id));
		r.setName(dto.getName());
		r.setCreatedAt(dto.getCreatedAt());
		return mapper.map(repo.save(r), RoleDto.class);
	}

	@Override
	public RoleDto retrive(Long id) {
		Role r = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Role", "ID", id));
		return mapper.map(r, RoleDto.class);
	}

	@Override
	public void delete(Long id) {
		Role r = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Role", "ID", id));
		repo.delete(r);
	}

}
