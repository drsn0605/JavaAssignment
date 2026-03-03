package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student3;

public interface StudentService {
	public Student3 create(Student3 student);
	public List<Student3> read();
	public Student3 update(Student3 st, int id);
	public void destroy(int id);
	public Student3 retrive(int id);
}
