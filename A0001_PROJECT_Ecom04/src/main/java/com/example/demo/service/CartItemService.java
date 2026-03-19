package com.example.demo.service;

import com.example.demo.dto.CartItemDto;

public interface CartItemService {

	public CartItemDto create(CartItemDto dto);
//	public List<CartItemDto> list(); -> we dont need to create this method. 
	//we can get cart by cartByUser method. 
	
	public void destroy(Long id);
}
