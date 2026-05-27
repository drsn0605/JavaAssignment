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

import com.example.demo.dto.QuizDto;
import com.example.demo.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	QuizService quizservice;
	
	@PostMapping("/")
	public ResponseEntity<QuizDto> create(@RequestBody QuizDto dto) {
		QuizDto created = quizservice.create(dto);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}
	
	@GetMapping()
	public ResponseEntity<List<QuizDto>> list() {
		List<QuizDto> dtos = quizservice.list();
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<QuizDto> update(@RequestBody QuizDto dto,@PathVariable("id") Long id) {
		QuizDto updated = quizservice.update(dto, id);
		return new ResponseEntity<>(updated, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> destroy(@PathVariable("id") Long id) {
		quizservice.destroy(id);
		return ResponseEntity.ok("Quiz deleted");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<QuizDto> retrive(@PathVariable("id") Long id) {
		QuizDto dto = quizservice.retrive(id);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
}
