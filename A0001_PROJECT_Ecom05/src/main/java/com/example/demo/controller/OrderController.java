package com.example.demo.controller;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.AddressDto;
import com.example.demo.dto.CartDto;
import com.example.demo.dto.CartItemDtoViews;
import com.example.demo.dto.OrderDto;
import com.example.demo.dto.OrderItemDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.service.AddressService;
import com.example.demo.service.CartItemService;
import com.example.demo.service.CartService;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	UserService userservice;
	
	@Autowired
	AddressService addservice;
	
	@Autowired
	OrderService orderservice;
	
	@Autowired
	CartService cartservice;

	@Autowired
	ModelMapper mapper;
	 
	@Autowired
	CartItemService cartitemservice;
	
	@PostMapping("/")
	public void create(@RequestBody OrderDto dto, @RequestParam("address") Long aid) {
		UserDto user = userservice.retrive(1l);
		AddressDto address = addservice.retrive(aid);
//		List<AddressDto> alist = addservice.findByUser(user.getId());
		
		dto.setUser(user);
		dto.setAddress(address);
		
		OrderDto created = orderservice.create(dto);
		//we will order from cart. So, first we have to get cart and all items of that cart.
		CartDto cart = cartservice.cartByUser(mapper.map(user, User.class));
		//now we have to get all items from cart and store tht into OrderItemDto.
		OrderItemDto odto = new OrderItemDto();
		for(CartItemDtoViews cartItem : cart.getItems()) {
			odto.setOrder(created);
			odto.setProduct(cartItem.getProduct());
			odto.setQty(cartItem.getQty());
			odto.setPrice(cartItem.getProduct().getPrice());
			
			orderservice.create(odto);
			
			//now we want to delete all items from cart.
			cartitemservice.destroy(cartItem.getId());
		}
		
		//we also want to delete cart. 
		cartservice.destroy(cart.getId());
	}
	
	@GetMapping("/")
	public ResponseEntity<List<OrderDto>> list() {
		UserDto user = userservice.retrive(1l);
		List<OrderDto> dtos = orderservice.list(user);
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<List<OrderDto>> listAll() {
		List<OrderDto> dtos = orderservice.listAll();
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
}
