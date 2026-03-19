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
	CartRepo repo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public CartDto create(CartDto cart) {
		Cart c = mapper.map(cart, Cart.class);
		return mapper.map(repo.save(c), CartDto.class);
	}

	@Override
	public CartDto cartByUser(User user) {    //Purpose : Find cart belonging to a user.
		
		CartDto dt = null;
		
		Cart c = repo.findByUser(user);  //search cart using user.
		if(c != null) {
			dt = mapper.map(c, CartDto.class);  //if cart found - we will return cart(c). But we have to convert it into CartDto. 
		}
		//if cart not found - we will return null(CartDto dt = null). So, we will return dt.
		return dt;  
	}

	@Override
	public void delete(Long id) {
		Cart c = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Cart", "ID", id));
		repo.delete(c);
	}

}
