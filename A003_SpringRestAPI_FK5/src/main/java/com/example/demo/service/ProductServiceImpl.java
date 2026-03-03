package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product5;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepo repo;
	
	@Override
	public Product5 create(Product5 p) {
		return repo.save(p);
	}

	@Override
	public List<Product5> list() {
		return repo.findAll();
	}

	@Override
	public Product5 update(int id, Product5 p) {
		Product5 pro = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product5","ID",id));
		pro.setName(p.getName());
		pro.setPrice(p.getPrice());
		pro.setQty(p.getQty());
		pro.setCategory(p.getCategory());
		return pro;
	}

	@Override
	public void destroy(int id) {
		Product5 p = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product5","ID",id));
		repo.delete(p);
	}

	@Override
	public Product5 retrive(int id) {
		Product5 p = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product5","ID",id));
		return p;
	}

}
