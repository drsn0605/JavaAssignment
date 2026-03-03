package com.example.demo.payload;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<APIErr> ResourceNotFoundExceptionHandler(ResourceNotFoundException e) {
//		System.out.println(e.getMessage());
		APIErr err = new APIErr();
		err.setSuccess(false);
		err.setMessage(e.getMessage());
		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
	public void MethodArgumentNotValidException(org.springframework.web.bind.MethodArgumentNotValidException e) {
		
//		Map<String, String> errors = new HashMap<>();
		e.getBindingResult().getAllErrors().forEach((err)->{
			
			System.out.println(err.getDefaultMessage());
//			String field = err.getField();
//			String message = err.getDefaultMessage();
//			
//			errors.put(field, message);
		});
		
//		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
}
