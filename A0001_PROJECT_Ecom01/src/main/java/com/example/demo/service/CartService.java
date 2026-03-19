package com.example.demo.service;

import com.example.demo.dto.CartDto;
import com.example.demo.model.User;

public interface CartService {

	public CartDto create(CartDto cart);
	public CartDto cartByUser(User user);
	public void delete(Long id);
}
