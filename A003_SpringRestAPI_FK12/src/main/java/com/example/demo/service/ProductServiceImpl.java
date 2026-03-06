package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product12;
import com.example.demo.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepo repo;
	
	@Override
	public Product12 create(Product12 p) {
		// TODO Auto-generated method stub
		return repo.save(p);
	}

	@Override
	public List<Product12> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Product12 update(Product12 p, int id) {
		// TODO Auto-generated method stub
		Product12 pro = repo.findById(id).orElseThrow();
		
		return null;
	}

	@Override
	public void destroy(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product12 retrive(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
