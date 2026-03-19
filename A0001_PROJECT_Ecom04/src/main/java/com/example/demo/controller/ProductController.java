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
	ProductService service;
	
	@Autowired
	CategoryService cservice;

	@PostMapping("/cat/{id}")
	public ResponseEntity<ProductDto> create(@RequestBody ProductDto dto, @PathVariable Long id) {
		CategoryDto cat = cservice.retrive(id);
		dto.setCategory(cat);
		ProductDto created = service.create(dto);
		return new ResponseEntity<>(created,HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<ProductDto>> list() {
		List<ProductDto> dtos = service.list();
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@PutMapping("/{pid}")
	public ResponseEntity<ProductDto> update(@RequestBody ProductDto dto,@PathVariable Long pid,@RequestParam("cat") Long cid) {
		CategoryDto cat = cservice.retrive(cid);
		dto.setCategory(cat);
		ProductDto updated = service.update(dto, pid);
		return new ResponseEntity<>(updated, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		service.destroy(id);
		return ResponseEntity.ok("Product deleted");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> retrive(@PathVariable Long id) {
		ProductDto dto = service.retrive(id);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}
