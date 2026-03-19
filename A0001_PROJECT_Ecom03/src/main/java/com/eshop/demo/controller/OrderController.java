package com.eshop.demo.controller;

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

import com.eshop.demo.dto.AddressDto;
import com.eshop.demo.dto.CartDto;
import com.eshop.demo.dto.CartItemDtoViews;
import com.eshop.demo.dto.OrderDto;
import com.eshop.demo.dto.OrderItemDto;
import com.eshop.demo.dto.UserDto;
import com.eshop.demo.model.User;
import com.eshop.demo.service.AddressService;
import com.eshop.demo.service.CartItemService;
import com.eshop.demo.service.CartService;
import com.eshop.demo.service.OrderService;
import com.eshop.demo.service.UserService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	AddressService addservice;
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	OrderService orderservice;
	
	@Autowired
	CartService cartservice;
	
	@Autowired
	CartItemService cartitemservice;
	
	@PostMapping("/")
	public void create(@RequestBody OrderDto dto,@RequestParam("address") Long aid ) {
		UserDto user = userservice.retrive(2l);
		AddressDto adr = addservice.retrive(aid);
		dto.setAddress(adr);
		dto.setUser(user);
		
		OrderDto orderCreated = orderservice.create(dto);
//		return new ResponseEntity<>(created, HttpStatus.CREATED);
		//now we have to order from cart. So, we want cart of user.
		CartDto cart = cartservice.CartByUser(mapper.map(user, User.class));
		
		OrderItemDto odto = new OrderItemDto();
		for(CartItemDtoViews cartItem : cart.getItems()) {
			odto.setOrder(orderCreated);
			odto.setProduct(cartItem.getProduct());
			odto.setQty(cartItem.getQty());
			odto.setPrice(cartItem.getProduct().getPrice());
			
			orderservice.create(odto);
			
			//now we want to delete cartitems. So, 
			cartitemservice.delete(cartItem.getId());
		}
		
		//now we also want to delete cart. So, 
		cartservice.destroy(cart.getId());
	}
	
	//now we want all orders of perticular user. So,
	@GetMapping("/")
	public ResponseEntity<List<OrderDto>> list() {
		UserDto user = userservice.retrive(2l);
		List<OrderDto> dtos = orderservice.list(user);
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<List<OrderDto>> listAll() {
		List<OrderDto> dtos = orderservice.list();
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
}
