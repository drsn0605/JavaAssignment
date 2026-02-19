package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Student4;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public class StudentDaoImpl implements StudentDao{
	
	@Autowired
	SessionFactory factory;
	
	@Override
	public void addOrUpdate(Student4 student) {
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		s.saveOrUpdate(student);
		tx.commit();
	}

	@Override
	public List<Student4> viewStudent() {
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		return s.createQuery("from Student4", Student4.class).list();
	}

	@Override
	public void deleteStudent(int id) {
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		Student4 st = s.get(Student4.class, id);
		s.delete(st);
		tx.commit();
	}

	@Override
	public Student4 getStudentById(int id) {
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		return s.get(Student4.class, id);
	}

}
