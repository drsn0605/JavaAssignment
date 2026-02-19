package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product5;
import com.example.demo.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepo proRepo;
	
	@Override
	public void addOrUpdate(Product5 product) {
		proRepo.save(product);
		
	}

	@Override
	public List<Product5> viewProducts() {
		return proRepo.findAll();
	}

	@Override
	public void deleteProduct(int id) {
		proRepo.deleteById(id);
	}

	@Override
	public Product5 getById(int id) {
		return proRepo.findById(id).orElseThrow();
	}


}
