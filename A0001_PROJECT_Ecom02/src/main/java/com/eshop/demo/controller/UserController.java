package com.eshop.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> update(@RequestBody UserDto dto, @PathVariable("id") Long uid, @RequestParam("role") Long rid) {
		RoleDto r = rservice.retrive(rid);
		dto.setRole(r);
		UserDto updated = service.update(dto, uid);
		return new ResponseEntity<>(updated, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long uid) {
		service.destroy(uid);
		return ResponseEntity.ok("User deleted");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> retrive(@PathVariable("id") Long id) {
		UserDto dto = service.retrive(id);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/role/{rid}")
	public ResponseEntity<List<UserDto>> retriveByRole(@PathVariable("rid") Long id) {
		List<UserDto> dtos = service.retriveByRole(id);
		return new ResponseEntity<>(dtos, HttpStatus.OK);
		
	}
}
