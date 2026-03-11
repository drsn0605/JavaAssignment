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
import com.example.demo.service.AddressService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	UserService uservice;
	
	@Autowired
	AddressService aservice;
	
	@PostMapping("/")
	public ResponseEntity<AddressDto> create(@RequestBody AddressDto address, @RequestParam("user") Long id) {
		address.setUser(uservice.retrive(id));
		AddressDto created = aservice.create(address);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<AddressDto>> list() {
		List<AddressDto> dtos = aservice.list();
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AddressDto> update(@RequestBody AddressDto dto, @PathVariable("id") Long id) {
		AddressDto updated = aservice.update(dto, id);
		return new ResponseEntity<>(updated, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		aservice.destroy(id);
		return ResponseEntity.ok("Address deleted");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AddressDto> retrive(@PathVariable("id") Long id) {
		AddressDto dto = aservice.retrive(id);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<List<AddressDto>> getByUser(@PathVariable("id") Long uid) {
		List<AddressDto> dtos = aservice.getByUser(uid);
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
}
