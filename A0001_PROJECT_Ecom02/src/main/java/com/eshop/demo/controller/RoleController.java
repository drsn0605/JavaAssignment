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
import org.springframework.web.bind.annotation.RestController;

import com.eshop.demo.dto.RoleDto;
import com.eshop.demo.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	RoleService service;
	
	@PostMapping("/")
	public ResponseEntity<RoleDto> create(@RequestBody RoleDto dto ) {
		RoleDto created = service.create(dto);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<RoleDto>> list() {
		List<RoleDto> dtos = service.list();
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@PutMapping("/{rid}")
	public ResponseEntity<RoleDto> update(@RequestBody RoleDto dto, @PathVariable Long rid) {
		RoleDto updated = service.update(dto, rid);
		return new ResponseEntity<>(updated, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{rid}")
	public ResponseEntity<String> destroy(@PathVariable Long rid) {
		service.destroy(rid);
		return ResponseEntity.ok("Role deleted");
	}
	
	@GetMapping("/{rid}")
	public ResponseEntity<RoleDto> retrive(@PathVariable Long rid) {
		RoleDto dto = service.retrive(rid);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
}
