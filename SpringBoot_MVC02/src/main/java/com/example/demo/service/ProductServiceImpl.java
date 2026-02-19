package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product2;
import com.example.demo.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepo productRepo;
	
	@Override
	public void addOrUpdate(Product2 product) {
		productRepo.save(product);
		
	}

	@Override
	public List<Product2> viewProducts() {
		
		return productRepo.findAll();
	}

	@Override
	public Product2 getById(int id) {
		
		return productRepo.findById(id).orElseThrow();
	}

	@Override
	public void deleteProduct(int id) {
		productRepo.deleteById(id);
		
	}

}
