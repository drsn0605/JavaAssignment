package com.eshop.demo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.demo.dto.OrderDto;
import com.eshop.demo.dto.OrderItemDto;
import com.eshop.demo.dto.UserDto;
import com.eshop.demo.model.Order;
import com.eshop.demo.model.OrderItem;
import com.eshop.demo.model.User;
import com.eshop.demo.repo.OrderItemRepo;
import com.eshop.demo.repo.OrderRepo;
import com.eshop.demo.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepo repo;
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	OrderItemRepo itemrepo;
	
	@Override
	public OrderDto create(OrderDto dto) {
		Order order = mapper.map(dto, Order.class);
		Order created = repo.save(order);
		return mapper.map(created, OrderDto.class);
	}

	@Override
	public OrderItemDto create(OrderItemDto dto) {
		OrderItem created = itemrepo.save(mapper.map(dto, OrderItem.class));
		return mapper.map(created, OrderItemDto.class);
	}

	@Override
	public List<OrderDto> list(UserDto user) {
		List<Order> orders = repo.findByUser(mapper.map(user, User.class));
		List<OrderDto> dtos = orders.stream().map(o->{
			return mapper.map(o, OrderDto.class);
		}).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public List<OrderDto> list() {
		List<Order> orders = repo.findAll();
		List<OrderDto> dtos = orders.stream().map(ord->{
			return mapper.map(ord, OrderDto.class);
		}).collect(Collectors.toList());
		return dtos;
	}

}
