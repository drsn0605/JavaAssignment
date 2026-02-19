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

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@PostMapping("/students")
	public ResponseEntity<Student> create(@RequestBody Student st) {
		Student createStudent = service.create(st);
		return new ResponseEntity<>(createStudent,HttpStatus.CREATED);
	}
	
	@GetMapping("/students")
	public ResponseEntity read(){
		List<Student> students = service.read();
		return new ResponseEntity(students, HttpStatus.OK);
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity retrive(@PathVariable int id) {
		Student students = service.retrive(id);
		return new ResponseEntity(students, HttpStatus.CREATED);
	}
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> update(@PathVariable int id, @RequestBody Student st) {
		Student updateStudent = service.update(id, st);
		return new ResponseEntity(updateStudent, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity delete(@PathVariable int id) {
		service.destroy(id);
		return new ResponseEntity(HttpStatus.OK);
	}
}
