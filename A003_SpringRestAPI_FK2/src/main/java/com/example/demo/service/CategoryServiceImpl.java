package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category2;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepo repo;
	
	@Override
	public Category2 create(Category2 category) {
		// TODO Auto-generated method stub
		return repo.save(category);
	}

	@Override
	public List<Category2> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Category2 update(Category2 c, int id) {
		// TODO Auto-generated method stub
		Category2 cat = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category2","ID",id));
		cat.setName(c.getName());
		return repo.save(cat);
	}

	@Override
	public void destroy(int id) {
		// TODO Auto-generated method stub
		Category2 c = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category2", "ID", id));
		repo.delete(c);
	}

	@Override
	public Category2 retrive(int cid) {
		// TODO Auto-generated method stub
		return repo.findById(cid).orElseThrow(()-> new ResourceNotFoundException("Category2", "ID", cid));
	}

}
