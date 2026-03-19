package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.OrderDto;
import com.example.demo.dto.OrderItemDto;
import com.example.demo.dto.UserDto;

public interface OrderService {

	public OrderDto create(OrderDto dto);
	public OrderItemDto create(OrderItemDto dto);
	public List<OrderDto> list(UserDto user);
	public List<OrderDto> list();
}
