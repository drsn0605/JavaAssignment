package com.example.demo.payload;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public void ResourceNotFoundExceptionHandler(ResourceNotFoundException e) {
//		System.out.println(e.getMessage());
		APIErr err = new APIErr();
		err.setSuccess(false);
		err.setMessage(e.getMessage());
	}
}
