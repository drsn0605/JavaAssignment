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
	public ResponseEntity<RoleDto> create(@RequestBody RoleDto role) {
		RoleDto created = service.create(role);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<RoleDto>> list() {
		List<RoleDto> roles = service.list();
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<RoleDto> update(@RequestBody RoleDto dto, @PathVariable Long id) {
		RoleDto updated = service.update(dto, id);
		return new ResponseEntity<>(updated, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		service.destroy(id);
		return ResponseEntity.ok("Role deleted");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RoleDto> retrive(@PathVariable Long id) {
		RoleDto dto = service.retrive(id);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}
