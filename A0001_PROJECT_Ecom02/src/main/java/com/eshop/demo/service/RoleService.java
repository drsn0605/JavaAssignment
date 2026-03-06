package com.eshop.demo.service;

import java.util.List;

import com.eshop.demo.dto.RoleDto;

public interface RoleService {
	
	public RoleDto create(RoleDto dto);
	public List<RoleDto> list();
	public RoleDto update(RoleDto dto, Long rid);
	public void destroy(Long rid);
	public RoleDto retrive(Long rid);
}
