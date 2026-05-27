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
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userservice;
	
	@Autowired
	RoleService roleservice;
	
	@PostMapping("/")
	public ResponseEntity<UserDto> create(@RequestBody UserDto dto, @RequestParam("role") Long id) {
		RoleDto role = roleservice.retrive(id);
		dto.setRole(role);
		UserDto created = userservice.create(dto);
		return new ResponseEntity<>(created , HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<UserDto>> list() {
		List<UserDto> dtos = userservice.list();
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> update(@RequestBody UserDto dto, @PathVariable("id") Long id, @RequestParam("rid") Long rid) {
		RoleDto role = roleservice.retrive(rid);
		dto.setRole(role);
		UserDto updated = userservice.update(dto, id);
		return new ResponseEntity<>(updated , HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> destroy(@PathVariable("id") Long id) {
		userservice.destroy(id);
		return ResponseEntity.ok("User deleted");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> retirve(@PathVariable("id") Long id) {
		UserDto dto = userservice.retrive(id);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/role/{id}")
	public ResponseEntity<List<UserDto>> findByRole(@PathVariable("id") Long id) {
		List<UserDto> dtos = userservice.findByRole(id);
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
}
