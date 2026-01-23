package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddStudent2 {
	public static void main(String[] args) {
		
		Student2 st = new Student2();
		st.setId(0);
		st.setName("Kishan");
		st.setEmail("kishan@gmail.com");
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student2.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
		s.persist(st);
		
		tx.commit();
	}

}
