package com.example.demo.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CartDto;
import com.example.demo.model.Cart;
import com.example.demo.model.User;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.CartRepo;
import com.example.demo.service.CartService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	ModelMapper mapper;
	
	@Autowired
	CartRepo repo;
	
	@Override
	public CartDto cartByUser(User user) {
		CartDto dt = null;
		Cart cart = repo.findByUser(user);
		if(cart != null) {
			dt = mapper.map(cart, CartDto.class);
		}
		return dt;
	}

	@Override
	public CartDto create(CartDto dto) {
		Cart cart = mapper.map(dto, Cart.class);
		return mapper.map(repo.save(cart), CartDto.class);
	}

	@Override
	public void destroy(Long id) {
		Cart c = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Cart", "ID", id));
		repo.delete(c);
	}

}
