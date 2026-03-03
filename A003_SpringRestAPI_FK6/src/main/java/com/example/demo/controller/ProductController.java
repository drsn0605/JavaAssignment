package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductDto;
import com.example.demo.model.Category6;
import com.example.demo.model.Product6;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService service;
	
	@Autowired
	CategoryService cservice;
	
	@PostMapping("/category/{id}")
	public ResponseEntity<ProductDto> create(@RequestBody Product6 p, @PathVariable("id") int id) {
		Category6 cat = cservice.retrive(id);
		p.setCategory(cat);
		Product6 created = service.create(p);
		return new ResponseEntity<>(ProductToDto(created), HttpStatus.CREATED);
	}
	
	public ProductDto ProductToDto(Product6 p) {
		ProductDto dto = new ProductDto();
		dto.setId(p.getId());
		dto.setName(p.getName());
		dto.setPrice(p.getPrice());
		dto.setQty(p.getQty());
		dto.setCategory(CategoryController.CategoryToDto(p.getCategory()));
		return dto;
	}
}
