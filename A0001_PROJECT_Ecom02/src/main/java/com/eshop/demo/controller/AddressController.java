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

import com.eshop.demo.dto.AddressDto;
import com.eshop.demo.dto.UserDto;
import com.eshop.demo.service.AddressService;
import com.eshop.demo.service.UserService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	AddressService addservice;
	
	@Autowired
	UserService uservice;
	
	@PostMapping("/")
	public ResponseEntity<AddressDto> create(@RequestBody AddressDto dto, @RequestParam("user") Long uid) {
		UserDto udto = uservice.retrive(uid);
		dto.setUser(udto);
		AddressDto created = addservice.create(dto);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<AddressDto>> list() {
		List<AddressDto> dtos = addservice.list();
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AddressDto> update(@RequestBody AddressDto dto, @PathVariable("id") Long id) {
		AddressDto updated = addservice.update(dto, id);
		return new ResponseEntity<>(updated, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		addservice.destroy(id);
		return ResponseEntity.ok("Address deleted");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AddressDto> retrive(@PathVariable("id") Long id) {
		AddressDto dto = addservice.retrive(id);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<List<AddressDto>> getByUser(@PathVariable("id") Long id) {
		List<AddressDto> dtos = addservice.getByUser(id);
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
}
