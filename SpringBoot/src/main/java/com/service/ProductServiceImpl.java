package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.model.Product;
import com.repo.ProductRepo;

public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepo productRepo;
	
	@Override
	public void addOrUpdate(Product product) {
		productRepo.save(product);
		
		
	}

	@Override
	public List<Product> allproduct() {
		return productRepo.findAll();
	}

	@Override
	public Product getId(int id) {
		
		return productRepo.findById(id).orElseThrow();
	}

	@Override
	public void deleteProduct(int id) {
		productRepo.deleteById(id);
		
	}
	
}
