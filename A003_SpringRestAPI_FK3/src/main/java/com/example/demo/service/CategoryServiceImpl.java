package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category3;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepo catrepo;
	
	@Override
	public Category3 create(Category3 c) {
		return catrepo.save(c);
	}

	@Override
	public List<Category3> view() {
		return catrepo.findAll();
	}

	@Override
	public Category3 update(Category3 cat, int id) {
		Category3 c = catrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category3","ID",id));
		c.setName(cat.getName());
		return catrepo.save(c);
	}

	@Override
	public void destroy(int id) {
		Category3 c = catrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category3","ID",id));
		catrepo.delete(c);
	}

	@Override
	public Category3 retrive(int id) {
		Category3 c = catrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category3","ID",id));
		return c;
	}

}
