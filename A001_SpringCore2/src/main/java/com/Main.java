package com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext cx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Student2 s1 = cx.getBean("std",Student2.class);
		s1.display();
	}

}
