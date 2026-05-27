package com.example.demo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.OrderDto;
import com.example.demo.dto.OrderItemDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.Order;
import com.example.demo.model.OrderItem;
import com.example.demo.model.User;
import com.example.demo.repo.OrderItemRepo;
import com.example.demo.repo.OrderRepo;
import com.example.demo.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	ModelMapper mapper;
	
	@Autowired
	OrderRepo repo;
	
	@Autowired
	OrderItemRepo oirepo;
	
	@Override
	public OrderDto create(OrderDto dto) {
		Order order = mapper.map(dto, Order.class);
		Order created = repo.save(order);
		return mapper.map(created, OrderDto.class);
	}

	@Override
	public OrderItemDto create(OrderItemDto dto) {
		OrderItem oi = mapper.map(dto, OrderItem.class);
		OrderItem created = oirepo.save(oi);
		return mapper.map(created, OrderItemDto.class);
	}

	@Override
	public List<OrderDto> list(UserDto user) {
		List<Order> olist = repo.findByUser(mapper.map(user, User.class));
		List<OrderDto> dtos = olist.stream().map(o->{
			return mapper.map(o, OrderDto.class);
		}).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public List<OrderDto> listAll() {
		List<Order> olist = repo.findAll();
		List<OrderDto> dtos = olist.stream().map(o->{
			return mapper.map(o, OrderDto.class);
		}).collect(Collectors.toList());
		return dtos;
	}

}
 