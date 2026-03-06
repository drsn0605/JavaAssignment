package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ProductDto;

public interface ProductService {

	public ProductDto create(ProductDto dto);
	public List<ProductDto> list();
	public ProductDto retrive(Long id);
	public ProductDto update(ProductDto dto, Long pid);
	public void destroy(Long pid);
}
