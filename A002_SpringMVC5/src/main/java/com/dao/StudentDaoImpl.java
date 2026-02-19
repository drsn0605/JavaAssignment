package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Student5;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao{

	@Autowired
	SessionFactory factory;
	
	@Override
	public void addOrUpdate(Student5 student) {
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		s.saveOrUpdate(student);
		tx.commit();	
	}

	@Override
	public List<Student5> viewStudent() {
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		return s.createQuery("from Student5", Student5.class).list();
	}

	@Override
	public Student5 getById(int id) {
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		return s.get(Student5.class, id);
	}

	@Override
	public void deleteStudent(int id) {
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		Student5 st = s.get(Student5.class, id);
		s.delete(st);
		tx.commit();
	}

}
