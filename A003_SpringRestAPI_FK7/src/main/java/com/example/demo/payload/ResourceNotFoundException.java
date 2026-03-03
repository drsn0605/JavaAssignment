package com.example.demo.payload;

public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException(String resource, String field, int id) {
		super(String.format("% with %s : %s is not found", resource, field, id));
	}
}
