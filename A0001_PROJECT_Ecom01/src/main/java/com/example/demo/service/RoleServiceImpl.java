package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Role;
import com.example.demo.repo.RoleRepo;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepo repo;
	
	@Override
	public Role create(Role r) {
		return repo.save(r);
	}

	@Override
	public List<Role> list() {
		return repo.findAll();
	}

	@Override
	public Role update(Role r, int id) {
		Role ro = repo.findById(id).orElseThrow();
		ro.setName(r.getName());
		return null;
	}

	@Override
	public void destroy(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Role retrive(int rid) {
		// TODO Auto-generated method stub
		return null;
	}

}
