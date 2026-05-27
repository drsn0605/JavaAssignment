package com.example.demo.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.QuizDto;
import com.example.demo.model.QuizModel;
import com.example.demo.payload.ResourceNotFoundException;
import com.example.demo.repo.QuizRepo;
import com.example.demo.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService{

	@Autowired
	QuizRepo repo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public QuizDto create(QuizDto dto) {
		QuizModel created = repo.save(mapper.map(dto, QuizModel.class));
		return mapper.map(created, QuizDto.class);
	}

	@Override
	public List<QuizDto> list() {
		List<QuizModel> qlist = repo.findAll();
		List<QuizDto> dtos = qlist.stream().map(q->{
			return mapper.map(q, QuizDto.class);
		}).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public QuizDto update(QuizDto dto, Long id) {
		QuizModel q = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("QuizModel", "ID", id));
		dto.setZname(q.getZname());
		return mapper.map(repo.save(q), QuizDto.class);
	}

	@Override
	public void destroy(Long id) {
		QuizModel q = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("QuizModel", "ID", id));
		repo.delete(q);
	}

	@Override
	public QuizDto retrive(Long id) {
		QuizModel q = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("QuizModel", "ID", id));
		return mapper.map(q, QuizDto.class);
	}

}
