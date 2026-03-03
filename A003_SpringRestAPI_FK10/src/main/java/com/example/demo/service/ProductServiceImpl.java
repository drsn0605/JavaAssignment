package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product10;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepo repo;
	
	@Override
	public Product10 create(Product10 product) {
		// TODO Auto-generated method stub
		return repo.save(product);
	}

	@Override
	public List<Product10> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Product10 update(int id, Product10 pro) {
		Product10 p = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product10","ID",id));
		p.setName(pro.getName());
		p.setPrice(pro.getPrice());
		p.setQty(pro.getQty());
		p.setCategory(pro.getCategory());
		return repo.save(p);
	}

	@Override
	public void destroy(int id) {
		Product10 p = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product10","ID",id));
		repo.delete(p);
	}

	@Override
	public Product10 retrive(int id) {
		Product10 p = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product10","ID",id));
		return p;
	}

}
