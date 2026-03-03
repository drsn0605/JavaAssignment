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

import com.example.demo.model.Student4;
import com.example.demo.repo.StudentRepo;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService service;

	@PostMapping("/students")
	public ResponseEntity<Student4> create(@RequestBody Student4 st) {
		Student4 createStudent = service.create(st);
		return new ResponseEntity<>(createStudent, HttpStatus.CREATED);
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student4>> read() {
		List<Student4> students = service.read();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Student4> update(@RequestBody Student4 st, @PathVariable("id") int id) {
		Student4 std = service.update(st, id);
		return new ResponseEntity<>(std, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		service.destroy(id);
		return ResponseEntity.ok("student deleted");
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student4> get(@PathVariable("id") int id) {
		Student4 st = service.retrive(id);
		return new ResponseEntity<>(st, HttpStatus.OK);
	}
}
