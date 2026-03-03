package com.example.demo.controller;

import java.util.ArrayList;
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
import com.example.demo.model.Category11;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	CategoryService cservice;
	
	@PostMapping("/")
	public ResponseEntity<Category11> create(@RequestBody Category11 cat) {
		Category11 created = cservice.create(cat);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<CategoryDto>> list() {
		List<Category11> clist = cservice.list();
		List<CategoryDto> dtos = new ArrayList<>();
		for(Category11 c : clist) {
			dtos.add(CategoryToDto(c));
		}
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> update(@RequestBody Category11 cat, @PathVariable int id) {
		Category11 updated = cservice.update(cat, id);
		return new ResponseEntity<>(CategoryToDto(updated), HttpStatus.CREATED); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> destroy(@PathVariable int id) {
		cservice.destroy(id);
		return ResponseEntity.ok("Category Deleted");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> retrive(@PathVariable int id) {
		Category11 cat = cservice.rerive(id);
		return new ResponseEntity<>(CategoryToDto(cat), HttpStatus.OK);
	}
	
	public static CategoryDto CategoryToDto(Category11 c) {
		CategoryDto dto = new CategoryDto();
		dto.setId(c.getId());
		dto.setName(c.getName());
		return dto;
	}
}
