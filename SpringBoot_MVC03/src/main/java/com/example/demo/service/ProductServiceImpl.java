package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product3;
import com.example.demo.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepo productRepo;
	
	@Override
	public void addOrUpdate(Product3 product) {
		productRepo.save(product);
		
	}

	@Override
	public List<Product3> viewProducts() {
		return productRepo.findAll();
	}

	@Override
	public void deleteProduct(int id) {
		productRepo.deleteById(id);
	}

	@Override
	public Product3 getProductById(int id) {
		return productRepo.findById(id).orElseThrow();
	}

}
