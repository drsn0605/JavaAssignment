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

import com.example.demo.model.Student3;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService service;
	
	@PostMapping("/students")
	public ResponseEntity<Student3> create(@RequestBody Student3 st) {
		Student3 newSt = service.create(st);
		return new ResponseEntity<>(newSt, HttpStatus.CREATED);
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student3>> read() {
		List<Student3> students = service.read();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Student3> update(@RequestBody Student3 st, @PathVariable("id") int id) {
		Student3 std2 = service.update(st, id);
		return new ResponseEntity<>(std2, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		service.destroy(id);
		return ResponseEntity.ok("Student deleted.");
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student3> retrive(@PathVariable("id") int id) {
		Student3 st = service.retrive(id);
		return new ResponseEntity<>(st, HttpStatus.OK);
		
	}
}
