package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.RoleDto;

public interface RoleService {

	public RoleDto create(RoleDto dto);
	public List<RoleDto> list();
	public RoleDto update(RoleDto dto,Long id);
	public RoleDto retrive(Long id);
	public void delete(Long id);
}
