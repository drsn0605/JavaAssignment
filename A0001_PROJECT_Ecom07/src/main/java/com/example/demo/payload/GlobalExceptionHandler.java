package com.example.demo.payload;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<APIErr> ResourceNotFoundExceptionHandler(ResourceNotFoundException e) {
//		e.getMessage();
		APIErr err = new APIErr();
		err.setSuccess(false);
		err.setMessage(e.getMessage());
		return new ResponseEntity<>(err , HttpStatus.NOT_FOUND);
	}
}
