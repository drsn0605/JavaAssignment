package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	CategoryService catservice;
	
	@Autowired
	ProductService proservice;
	
	@PostMapping("/")
	public ResponseEntity<ProductDto> create(@RequestBody ProductDto dto, @RequestParam("category") Long cid) {
		CategoryDto cat = catservice.retrive(cid);
		dto.setCategory(cat);
		ProductDto created = proservice.create(dto);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<ProductDto>> list() {
		List<ProductDto> dtos = proservice.list();
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductDto> update(@RequestBody ProductDto dto, @PathVariable("id") Long id, @RequestParam("category") Long cid) {
		CategoryDto cat = catservice.retrive(cid);
		dto.setCategory(cat);
		ProductDto updated = proservice.update(dto, id);
		return new ResponseEntity<>(updated, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> destroy(@PathVariable("id") Long id) {
		proservice.destroy(id);
		return ResponseEntity.ok("Product Deleted");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> retrive(@PathVariable("id") Long id) {
		ProductDto dto = proservice.retrive(id);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}
