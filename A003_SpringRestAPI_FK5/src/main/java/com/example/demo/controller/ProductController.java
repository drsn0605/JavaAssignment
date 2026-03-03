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
import com.example.demo.model.Category5;
import com.example.demo.model.Product5;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService pservice;
	
	@Autowired
	CategoryService cservice;
	
	@PostMapping("/category/{id}")
	public ResponseEntity<ProductDto> create(@RequestBody Product5 product, @PathVariable("id") int id) {
		Category5 c = cservice.retrive(id);
		product.setCategory(c);
		Product5 p = pservice.create(product);
		return new ResponseEntity<>(ProductToDto(p),HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<ProductDto>> list() {
		List<Product5> plist = pservice.list();
		List<ProductDto> dtos = new ArrayList<>();
		for(Product5 p : plist) {
			dtos.add(ProductToDto(p));
		}
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	public ProductDto ProductToDto(Product5 p) {
		ProductDto dto = new ProductDto();
		dto.setId(p.getId());
		dto.setName(p.getName());
		dto.setPrice(p.getPrice());
		dto.setQty(p.getQty());
//		dto.setCategory(CategoryController.CategoryToDto(p.getCategory()));
		if(p.getCategory() != null) {
			CategoryDto cdto = new CategoryDto();
			cdto.setId(p.getCategory().getId());
			cdto.setName(p.getCategory().getName());
			
			dto.setCategory(cdto);
		}
		return dto;
	}
}
