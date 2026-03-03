package com.example.demo.payload;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<APIErr> ResourceNotFoundExeptionHandler(ResourceNotFoundException e) {
		APIErr err = new APIErr();
		err.setSuccess(false);
		err.setMessage(e.getMessage());
		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}
}
