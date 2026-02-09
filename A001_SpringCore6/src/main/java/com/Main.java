package com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext cx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Student6 st = cx.getBean("std6",Student6.class);
		st.display();
	}
}
