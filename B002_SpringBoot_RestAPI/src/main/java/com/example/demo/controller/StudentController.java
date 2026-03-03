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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student2;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService service;
	
	@PostMapping("/students")
	public ResponseEntity<Student2> create(@RequestBody Student2 st) {
		Student2 st1 = service.create(st);
		return new ResponseEntity<>(st1,HttpStatus.CREATED);
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student2>> get() {
		List<Student2> stds = service.read();
		return new ResponseEntity<>(stds, HttpStatus.OK);
	}
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Student2> update(@RequestBody Student2 newSt,@PathVariable("id") int newId ) {
		Student2 std2 = service.update(newSt, newId);
		return new ResponseEntity<>(std2, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		service.destroy(id);
		return ResponseEntity.ok("Student deleted");
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student2> retrive(@PathVariable("id") int id) {
		Student2 st = service.retrive(id);
		return new ResponseEntity<>(st, HttpStatus.OK);
	}
}
