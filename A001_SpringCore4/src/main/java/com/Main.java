package com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext cx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Student4 st = cx.getBean("std",Student4.class);
		st.display();
	}

}
