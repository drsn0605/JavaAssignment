package com.dao;

import java.util.List;

import com.model.Student11;

public interface StudentDao {
	public void addOrUpdate(Student11 student);
	public List<Student11> viewStudents();
	public void deleteStudent(int id);
	public Student11 getById(int id);
}
