package com.example.demo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.ProductDto;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.ProductRepo;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepo repo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public ProductDto create(ProductDto dto) {
		Product p = mapper.map(dto, Product.class);
		return mapper.map(repo.save(p), ProductDto.class);
	}

	@Override
	public List<ProductDto> list() {
		List<Product> plist = repo.findAll();
		List<ProductDto> dtos = plist.stream().map(p->{
			return mapper.map(p, ProductDto.class);
		}).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public ProductDto update(ProductDto dto, Long id) {
		Product p = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product", "ID", id));
		p.setCategory(mapper.map(dto.getCategory(), Category.class));
		p.setName(dto.getName());
		p.setDescription(dto.getDescription());
		p.setPrice(dto.getPrice());
		p.setStockQty(dto.getStockQty());
		p.setImage(dto.getImage());
		p.setActive(dto.isActive());
		p.setCreatedAt(dto.getCreatedAt());
		return mapper.map(repo.save(p), ProductDto.class);
	}

	@Override
	public void destroy(Long id) {
		Product p = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product", "ID", id));
		repo.delete(p);
	}

	@Override
	public ProductDto retrive(Long id) {
		Product p = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product", "ID", id));
		return mapper.map(p, ProductDto.class);
	}
	
	

}
