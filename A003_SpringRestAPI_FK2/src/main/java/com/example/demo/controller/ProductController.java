package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.model.Category2;
import com.example.demo.model.Product2;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService proservice;
	
	@Autowired
	CategoryService catservice;
	
	@PostMapping("/category/{id}")
	public ResponseEntity<ProductDto> create(@RequestBody Product2 p,@PathVariable("id") int id) {
		Category2 c = catservice.retrive(id);
		p.setCategory(c);
		Product2 createdpro = proservice.create(p);
		return new ResponseEntity<>(ProductToDto(createdpro), HttpStatus.CREATED);
	}
	
	@GetMapping("/l")
	public ResponseEntity<List<ProductDto>> list() {
		List<Product2> plist = proservice.view();
		List<ProductDto> dtos = new ArrayList<>();
		for(Product2 p : plist) {
			dtos.add(ProductToDto(p));
		}
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	public ProductDto ProductToDto(Product2 p) {
		ProductDto pro = new ProductDto();
		pro.setId(p.getId());
		pro.setName(p.getName());
		pro.setPrice(p.getPrice());
		pro.setQty(p.getQty());
//		pro.setCategory(CategoryController.CategoryToDto(p.getCategory()));
		if(p.getCategory() != null) {
			CategoryDto cdto = new CategoryDto();
			cdto.setId(p.getCategory().getId());
			cdto.setName(p.getCategory().getName());
			
			pro.setCategory(cdto);
		}
		return pro;
	}
}
