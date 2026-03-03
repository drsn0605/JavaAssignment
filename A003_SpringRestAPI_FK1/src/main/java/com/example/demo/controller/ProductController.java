package com.example.demo.controller;

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

import com.example.demo.dto.ProductDto;
import com.example.demo.model.Category1;
import com.example.demo.model.Product1;
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
	public ResponseEntity<ProductDto> create(@RequestBody Product1 p, @PathVariable("id") int id) {
		
		Category1 cat =  catservice.retrive(id);
		p.setCategory(cat);
		Product1 created = proservice.create(p);
		return new ResponseEntity<>(ProductToDto(created), HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<Product1>> view() {
		List<Product1> prolist = proservice.view();
		return new ResponseEntity<>(prolist, HttpStatus.OK);
	}
	
	public ProductDto ProductToDto(Product1 p) {
		ProductDto pro = new ProductDto();
		pro.setId(p.getId());
		pro.setName(p.getName());
		pro.setPrice(p.getPrice());
		pro.setQty(p.getQty());
//		pro.setCategory(p.getCategory());  //error - first we have to convert this p.getCategory() into CategoryDto.
		pro.setCategory(CategoryController.CategoryToDto(p.getCategory()));
		return pro;
	}
}
