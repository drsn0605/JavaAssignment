package com.eshop.demo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.demo.dto.AddressDto;
import com.eshop.demo.dto.UserDto;
import com.eshop.demo.model.Address;
import com.eshop.demo.model.User;
import com.eshop.demo.payload.ResourceNotFoundException;
import com.eshop.demo.repo.AddressRepo;
import com.eshop.demo.service.AddressService;
import com.eshop.demo.service.UserService;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	AddressRepo repo;
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	UserService uservice;
	
	@Override
	public AddressDto create(AddressDto address) {
		Address adr = repo.save(mapper.map(address, Address.class));
		return mapper.map(adr, AddressDto.class);
	}

	@Override
	public List<AddressDto> list() {
		List<Address> alist = repo.findAll();
		List<AddressDto> dtos = alist.stream().map(a->{
			return mapper.map(a, AddressDto.class);
		}).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public AddressDto update(AddressDto dto, Long id) {
		Address adr = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Address", "ID", id));
		adr.setAddressLine(dto.getAddressLine());
		adr.setCity(dto.getCity());
		adr.setState(dto.getState());
		adr.setPincode(dto.getPincode());
		adr.setCountry(dto.getCountry());
		adr.setDefault(dto.isDefault());
		return mapper.map(repo.save(adr), AddressDto.class);
	}

	@Override
	public void destroy(Long id) {
		Address adr = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Address", "ID", id));
		repo.delete(adr);
	}

	@Override
	public AddressDto retrive(Long id) {
		Address adr = repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Address", "ID", id));
		return mapper.map(adr, AddressDto.class);
	}

	@Override
	public List<AddressDto> getByUser(Long id) {
//		UserDto u = uservice.retrive(id);
		User user = mapper.map(uservice.retrive(id), User.class);
		List<Address> alist = repo.findByUser(user);
		List<AddressDto> dtos = alist.stream().map(a->{
			return mapper.map(a, AddressDto.class);
		}).collect(Collectors.toList());
		return dtos;
	}

}
