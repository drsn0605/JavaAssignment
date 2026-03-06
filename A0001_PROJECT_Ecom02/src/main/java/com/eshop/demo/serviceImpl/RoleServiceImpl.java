package com.eshop.demo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.demo.dto.RoleDto;
import com.eshop.demo.model.Role;
import com.eshop.demo.payload.ResourceNotFoundException;
import com.eshop.demo.repo.RoleRepo;
import com.eshop.demo.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepo repo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public RoleDto create(RoleDto dto) {
		Role r = mapper.map(dto, Role.class);
		Role created = repo.save(r);
		return mapper.map(created, RoleDto.class);
	}

	@Override
	public List<RoleDto> list() {
		List<Role> plist = repo.findAll();
		List<RoleDto> dtos = plist.stream().map(p->{
			return mapper.map(p, RoleDto.class);
		}).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public RoleDto update(RoleDto dto, Long rid) {
		Role r = repo.findById(rid).orElseThrow(()-> new ResourceNotFoundException("Role","ID",rid));
		r.setName(dto.getName());
		return mapper.map(repo.save(r), RoleDto.class);
	}

	@Override
	public void destroy(Long rid) {
		Role r = repo.findById(rid).orElseThrow(()-> new ResourceNotFoundException("Role","ID",rid));
		repo.delete(r);
	}

	@Override
	public RoleDto retrive(Long rid) {
		Role r = repo.findById(rid).orElseThrow(()-> new ResourceNotFoundException("Role","ID",rid));
		return mapper.map(r, RoleDto.class);
	}
	
	

}
