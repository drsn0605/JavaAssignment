package com.dao;

import java.util.List;

import com.model.Student10;

public interface StudentDao {
	public void addOrUpdate(Student10 student);
	public List<Student10> viewStudent();
	public void deleteStudent(int id);
	public Student10 getById(int id);
}
