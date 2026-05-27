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

import com.example.demo.dto.AddressDto;
import com.example.demo.dto.UserDto;
import com.example.demo.service.AddressService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	AddressService adrservice;
	
	@Autowired
	UserService userservice;
	
	@PostMapping("/")
	public ResponseEntity<AddressDto> create(@RequestBody AddressDto dto, @RequestParam("user") Long id) {
		UserDto user = userservice.retrive(id);
		dto.setUser(user);
		AddressDto created = adrservice.create(dto);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<AddressDto>> list() {
		List<AddressDto> dtos = adrservice.list();
		 return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AddressDto> update(@RequestBody AddressDto dto, @PathVariable("id") Long id) {
		AddressDto updated = adrservice.update(dto, id);
		return new ResponseEntity<>(updated, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AddressDto> retrive(@PathVariable("id") Long id) {
		AddressDto dto = adrservice.retrive(id);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> destroy(@PathVariable("id") Long id) {
		adrservice.destroy(id);
		return ResponseEntity.ok("Address deleted");
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<List<AddressDto>> findByUser(@PathVariable("id") Long id) {
		List<AddressDto> dtos = adrservice.findByUser(id);
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
}
