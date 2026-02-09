package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddStudent {
	public static void main(String[] args) {
		
		Student st = new Student();
		st.setId(3);
		st.setName("kishan");
		st.setEmail("kishan@gmail.com");
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		
//		System.out.println("done1");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
		s.persist(st);    //s.merge(st); - for update
		
		tx.commit();
		
	}

}
