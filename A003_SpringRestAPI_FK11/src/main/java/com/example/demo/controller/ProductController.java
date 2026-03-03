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
import com.example.demo.dto.ProductDto;
import com.example.demo.model.Category11;
import com.example.demo.model.Product11;
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
	public ResponseEntity<ProductDto> create(@RequestBody Product11 pro, @PathVariable int id) {
		Category11 c = cservice.rerive(id);
		pro.setCategory(c);
		Product11 created = pservice.create(pro);
		return new ResponseEntity<>(ProductToDto(created), HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<ProductDto>> list() {
		List<Product11> plist = pservice.list();
		List<ProductDto> dtos = new ArrayList<>();
		for(Product11 p : plist) {
			dtos.add(ProductToDto(p));
		}
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@PutMapping("/{id}/category/{cid}")
	public ResponseEntity<ProductDto> update(@RequestBody Product11 pro, @PathVariable int id, @PathVariable int cid) {
		Product11 p = pservice.update(pro, id);
		Category11 c = cservice.rerive(cid);
		p.setCategory(c);
		return new ResponseEntity<>(ProductToDto(p), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> destroy(@PathVariable int id) {
		pservice.destroy(id);
		return ResponseEntity.ok("Product Deleted");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> retrive(@PathVariable int id) {
		Product11 p = pservice.retrive(id);
		return new ResponseEntity<>(ProductToDto(p), HttpStatus.OK);
	}
	
	public ProductDto ProductToDto(Product11 p) {
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
