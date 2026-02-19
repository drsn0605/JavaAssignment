package dao;    //model class

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Student;

public class StudentDao {
	
	SessionFactory sf = null;  //make sf global
	
	public StudentDao() {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		sf = cfg.buildSessionFactory();
	}
	
	public int addStudent(Student st) {   
		int i = 0;
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.persist(st);
		tx.commit();
		i = 1;
		
		return i;
		
	} 
	
	public ArrayList<Student> viewStudents() {   
		
		ArrayList<Student> al = null;
		

		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		al = (ArrayList<Student>) s.createQuery("from Student").list();
		
		return al;
	}
	
	public int deleteStudent(int id) {
		int i = 0;
	
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		Student st = s.find(Student.class, id);
		s.remove(st);
		tx.commit();
		i = 1;
		
		return i;  
	}
	
	public Student getStudentById(int eid) {
	
		
		Student st = new Student();   

		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		st = s.find(Student.class, eid);
		
		return st;
	}

	public int updateStudent(Student st) {
		int i = 0;
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.merge(st);
		tx.commit();
		i = 1;
		
		return i;
	}
}
