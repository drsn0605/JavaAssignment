package com.dao;

import java.util.List;

import com.model.Student9;

public interface StudentDao {
	public void addOrUpdate(Student9 student);
	public List<Student9> viewStudent();
	public Student9 getStudentById(int id);
	public void deleteStudent(int id);
}
