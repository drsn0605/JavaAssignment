package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AddressDto;

public interface AddressService {

	public AddressDto create(AddressDto dto);
	public List<AddressDto> list();
	public AddressDto update(AddressDto dto, Long id);
	public AddressDto retrive(Long id);
	public void destroy(Long id);
	public List<AddressDto> findByUser(Long id);
}
