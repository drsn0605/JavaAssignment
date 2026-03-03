package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category4;
import com.example.demo.repo.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepo crepo;
	
	@Override
	public Category4 create(Category4 c) {
		return crepo.save(c);
	}

	@Override
	public List<Category4> list() {
		return crepo.findAll();
	}

	@Override
	public Category4 update(Category4 c, int id) {
		Category4 cat = crepo.findById(id).orElseThrow();
		cat.setName(c.getName());
		return cat;
	}

	@Override
	public void destroy(int id) {
		Category4 cat = crepo.findById(id).orElseThrow();
		crepo.delete(cat);
	}

	@Override
	public Category4 retrive(int id) {
		Category4 cat = crepo.findById(id).orElseThrow();
		return cat;
	}

}
