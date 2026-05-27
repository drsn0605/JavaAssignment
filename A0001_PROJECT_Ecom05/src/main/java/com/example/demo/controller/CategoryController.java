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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CategoryDto;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	CategoryService catservice;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto dto) {
		CategoryDto created = catservice.create(dto);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<CategoryDto>> list() {
		List<CategoryDto> dtos = catservice.list();
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto dto, @PathVariable("id") Long id) {
		CategoryDto updated = catservice.update(dto, id);
		return new ResponseEntity<>(updated, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> retrive(@PathVariable("id") Long id) {
	 	CategoryDto dto = catservice.retrive(id);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> destroy(@PathVariable("id") Long id) {
		catservice.delete(id);
		return ResponseEntity.ok("Category deleted");
	}
}
