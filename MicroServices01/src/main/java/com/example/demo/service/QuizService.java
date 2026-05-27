package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.QuizDto;

public interface QuizService {

	public QuizDto create(QuizDto dto);
	public List<QuizDto> list();
	public QuizDto update(QuizDto dto, Long id);
	public void destroy(Long id);
	public QuizDto retrive(Long id);
}
