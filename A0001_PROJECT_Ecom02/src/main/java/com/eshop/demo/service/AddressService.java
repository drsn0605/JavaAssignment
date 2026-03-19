package com.eshop.demo.service;

import java.util.List;

import com.eshop.demo.dto.AddressDto;

public interface AddressService {

	public AddressDto create(AddressDto address);
	public List<AddressDto> list();
	public AddressDto update(AddressDto dto, Long id);
	public void destroy(Long id);
	public AddressDto retrive(Long id);
	public List<AddressDto> getByUser(Long id);
}
