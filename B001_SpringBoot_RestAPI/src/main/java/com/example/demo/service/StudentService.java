package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {
	public Student create(Student student);
	public List<Student> view();
	public Student retrive(int id);
	public void destroy(int id);
	public Student update(Student st,int id);
}
