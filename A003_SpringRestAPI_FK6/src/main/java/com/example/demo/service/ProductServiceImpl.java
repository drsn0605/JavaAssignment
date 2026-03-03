package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product6;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepo repo;
	
	@Override
	public Product6 create(Product6 p) {
		// TODO Auto-generated method stub
		return repo.save(p);
	}

	@Override
	public List<Product6> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Product6 update(int id, Product6 pro) {
		Product6 p = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product6","ID",id));
		p.setName(pro.getName());
		p.setPrice(pro.getPrice());
		p.setQty(pro.getQty());
		p.setCategory(pro.getCategory());
		return p;
	}

	@Override
	public void destroy(int id) {
		// TODO Auto-generated method stub
		Product6 p = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product6","ID",id));
		repo.delete(p);
		
	}

	@Override
	public Product6 retrive(int id) {
		Product6 p = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product6","ID",id));
		return p;
	}

}
