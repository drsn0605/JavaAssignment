package com.example.demo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.dto.ProductDto;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.ProductRepo;
import com.example.demo.service.ProductService;

@RestControllerAdvice
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepo repo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public ProductDto create(ProductDto dto) {
		Product created = repo.save(mapper.map(dto, Product.class));
		return mapper.map(created, ProductDto.class);
	}

	@Override
	public List<ProductDto> list() {
		List<Product> plist = repo.findAll();
		List<ProductDto> dtos = plist.stream().map(p->{
			return mapper.map(p,ProductDto.class);
		}).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public ProductDto update(ProductDto dto, Long id) {
		Product pro = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product", "ID", id));
		pro.setName(dto.getName());
		pro.setDescription(dto.getDescription());
		pro.setQty(dto.getQty());
		pro.setPrice(dto.getPrice());
		pro.setImage(dto.getImage());
		pro.setCreatedAt(dto.getCreatedAt());
		pro.setActive(dto.isActive());
		pro.setCategory(mapper.map(dto.getCategory(), Category.class));
		return mapper.map(repo.save(pro), ProductDto.class);
	}

	@Override
	public void destroy(Long id) {
		Product pro = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product", "ID", id));
		repo.delete(pro);
	}

	@Override
	public ProductDto retrive(Long id) {
		Product pro = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product", "ID", id));
		return mapper.map(pro, ProductDto.class);
	}

}
