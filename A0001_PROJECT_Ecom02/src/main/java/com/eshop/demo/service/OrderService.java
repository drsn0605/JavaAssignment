package com.eshop.demo.service;

import java.util.List;

import com.eshop.demo.dto.OrderDto;
import com.eshop.demo.dto.OrderItemDto;
import com.eshop.demo.dto.UserDto;

public interface OrderService {

	public OrderDto create(OrderDto dto);
	public OrderItemDto create(OrderItemDto dto);
	public List<OrderDto> list(UserDto user);
	public List<OrderDto> list();
}
