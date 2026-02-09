package com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext cx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Student5 st = cx.getBean("std5",Student5.class);
		st.display();
		
	}

}
