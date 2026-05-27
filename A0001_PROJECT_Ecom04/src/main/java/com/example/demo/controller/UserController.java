package com.example.demo.controller;

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

import com.example.demo.dto.RoleDto;
import com.example.demo.dto.UserDto;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService service;
	
	@Autowired
	RoleService rservice;
	
	@PostMapping("/{rid}")
	public ResponseEntity<UserDto> create(@RequestBody UserDto dto, @PathVariable Long rid) {
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
	
	@PutMapping("/{uid}")
	public ResponseEntity<UserDto> update(@RequestBody UserDto dto,@PathVariable("uid") Long uid, @RequestParam("role") Long rid) {
		RoleDto r = rservice.retrive(rid);
		dto.setRole(r);
		UserDto updated = service.update(dto, uid);
		return new ResponseEntity<>(updated, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		service.destroy(id);
		return ResponseEntity.ok("User deleted");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> retrive(@PathVariable Long id) {
		UserDto dto = service.retrive(id);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/role/{rid}")
	public ResponseEntity<List<UserDto>> getByRole(@PathVariable Long rid) {
		List<UserDto> dtos = service.findByRole(rid);
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
}
