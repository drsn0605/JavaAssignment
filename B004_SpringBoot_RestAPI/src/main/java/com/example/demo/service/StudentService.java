package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student4;

public interface StudentService {
	public Student4 create(Student4 st);
	public List<Student4> read();
	public Student4 update(Student4 st, int id);
	public void destroy(int id);
	public Student4 retrive(int id);
}
