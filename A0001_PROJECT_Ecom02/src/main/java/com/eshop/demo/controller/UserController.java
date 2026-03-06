package com.eshop.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.demo.dto.RoleDto;
import com.eshop.demo.dto.UserDto;
import com.eshop.demo.service.RoleService;
import com.eshop.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService service;
	
	@Autowired
	RoleService rservice;
	
	@PostMapping("/")
	public ResponseEntity<UserDto> create(@RequestBody UserDto dto, @RequestParam("role") Long rid ) {
		RoleDto r = rservice.retrive(rid);
		dto.setRole(r);
		UserDto created = service.create(dto);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<UserDto>> list() {
		List<UserDto> dtos = service.list();
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
}
