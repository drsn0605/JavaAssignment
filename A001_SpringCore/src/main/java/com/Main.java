package com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext cx = new ClassPathXmlApplicationContext("applicationContext.xml");   //ye file hame object bana ke dega. 
		
		Student s1 = cx.getBean("std",Student.class);
//		s1.display(); 
		
		//if we run s1.display() without defining any object - it will give "NullPointerException"
		//So first we have to give data to that variable(List<String> subjects & Set<String> languages) - where? -> in applicationContext.xml
		
		s1.display();
	}
}
