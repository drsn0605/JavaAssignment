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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RoleDto;
import com.example.demo.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	RoleService service;
	
	@PostMapping("/")
	public ResponseEntity<RoleDto> create(@RequestBody RoleDto dto) {
		RoleDto created = service.create(dto);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<RoleDto>> list() {
		List<RoleDto> dtos = service.list();
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<RoleDto> update(@RequestBody RoleDto role, @PathVariable Long id) {
		RoleDto updated = service.update(role, id);
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
