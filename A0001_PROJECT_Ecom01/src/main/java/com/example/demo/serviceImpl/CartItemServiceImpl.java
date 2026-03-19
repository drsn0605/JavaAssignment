package com.example.demo.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CartItemDto;
import com.example.demo.model.CartItem;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.CartItemRepo;
import com.example.demo.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService{

	@Autowired
	CartItemRepo repo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public CartItemDto create(CartItemDto dto) {
		CartItem item = mapper.map(dto, CartItem.class);
		CartItem created = repo.save(item);
		return mapper.map(created, CartItemDto.class);
	}

	@Override
	public void delete(Long id) {
//		repo.deleteById(id);
		CartItem ci = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("CartItem", "ID", id));
		repo.delete(ci);
	}

}
