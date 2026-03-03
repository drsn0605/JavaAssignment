package com.example.demo.payload;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExcptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public void ResourceNotFoundExceptionHandler(ResourceNotFoundException e) {
		APIErr err = new APIErr();
		err.setSuccess(false);
		err.setMessage(e.getMessage());
	}
}
