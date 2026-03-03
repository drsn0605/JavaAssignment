package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student2;

public interface StudentService {
	public Student2 create(Student2 student);
	public List<Student2> read();
	public Student2 update(Student2 st, int id);
	public void destroy(int id);
	public Student2 retrive(int id);
}
