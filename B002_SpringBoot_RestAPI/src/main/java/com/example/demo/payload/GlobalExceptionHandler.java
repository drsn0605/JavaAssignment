package com.example.demo.payload;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	public ResponseEntity<APIErr> ResourceNotFoundHandler(ResourceNotFoundException e) {
//		System.out.println(e.getMessage());
		APIErr err = new APIErr();
		err.setSuccess(false);
		err.setMessage(e.getMessage());
		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}
}
