package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Student7;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public class StudentDaoImpl implements StudentDao{

	@Autowired
	SessionFactory factory;

	@Override
	public void addOrUpdate(Student7 st) {
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		s.saveOrUpdate(st);
		tx.commit();
	}

	@Override
	public List<Student7> viewStudent() {
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		return s.createQuery("from Student7",Student7.class).list();
	}

	@Override
	public Student7 getById(int id) {
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		return s.get(Student7.class, id);
	}

	@Override
	public void deleteStudent(int id) {
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		Student7 st = s.get(Student7.class, id);
		s.delete(st);
		tx.commit();
		
	}

}
