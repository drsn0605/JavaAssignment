package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product4;
import com.example.demo.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepo productRepo;
	
	@Override
	public void addOrUpdate(Product4 product) {
		productRepo.save(product);
		
	}

	@Override
	public List<Product4> viewProduct() {
		return productRepo.findAll();
	}

	@Override
	public Product4 getById(int id) {
		return productRepo.findById(id).orElseThrow();
	}

	@Override
	public void deleteProduct(int id) {
		productRepo.deleteById(id);
		
	}
	

}
