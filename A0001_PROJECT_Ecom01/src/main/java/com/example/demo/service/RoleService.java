package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Role;

public interface RoleService {
	public Role create(Role r);
	public List<Role> list();
	public Role update(Role r, int id);
	public void destroy(int id);
	public Role retrive(int rid);
}
