package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CategoryDto;
import com.example.demo.model.Category2;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	CategoryService catservice;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> create(@RequestBody Category2 category) {
		Category2 created = catservice.create(category);
//		CategoryDto dto = new CategoryDto();
//		dto.setId(created.getId());
//		dto.setName(created.getName());
		return new ResponseEntity<>(CategoryToDto(created), HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<CategoryDto>> list() {
		List<Category2> clist = catservice.list();
		List<CategoryDto> dtos = new ArrayList<>();
		for(Category2 c : clist) {
			dtos.add(CategoryToDto(c));
		}
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	public static CategoryDto CategoryToDto(Category2 cat) {
		CategoryDto cdto = new CategoryDto();
		cdto.setId(cat.getId());
		cdto.setName(cat.getName());
		return cdto;
	}
	
	public Category2 DtoToCategory(CategoryDto dto) {
		Category2 c = new Category2();
		c.setId(dto.getId());
		c.setName(dto.getName());
		return c;
	}
}
