package com.dao;

import java.util.List;

import com.model.Student2;

public interface StudentDao {
	public void addOrUpdate(Student2 student);
	public List<Student2> viewStudent();
	public Student2 studentById(int id);
	public void deleteStudent(int id);
}
