package com.dao;

import java.util.List;

import com.model.Student8;

public interface StudentDao {
	public void addOrUpdate(Student8 student);
	public List<Student8> viewStudent();
	public Student8 getStudentById(int id);
	public void deleteStudent(int id);
}
