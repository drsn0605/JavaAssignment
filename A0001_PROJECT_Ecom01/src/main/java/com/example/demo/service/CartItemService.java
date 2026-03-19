package com.example.demo.service;

import com.example.demo.dto.CartItemDto;

public interface CartItemService {

	public CartItemDto create(CartItemDto dto);
	public void delete(Long id);
}
