package com.example.demo.payload;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException(String resource, String field, Long id) {
		super(String.format("%s with %s : %s is not found", resource, field, id));
	}
}
