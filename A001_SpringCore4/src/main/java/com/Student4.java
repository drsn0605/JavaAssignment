package com;

import java.util.List;
import java.util.Set;

public class Student4 {
	int id;
	String name;
	String email;
	
	List<String> subject;
	Set<String> lang;
	
	Address address;
	
	List<Marks> marks;
	
	public List<Marks> getMarks() {
		return marks;
	}
	public void setMarks(List<Marks> marks) {
		this.marks = marks;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<String> getSubject() {
		return subject;
	}
	public void setSubject(List<String> subject) {
		this.subject = subject;
	}
	public Set<String> getLang() {
		return lang;
	}
	public void setLang(Set<String> lang) {
		this.lang = lang;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void display() {
		System.out.println(id+" "+name+" "+email);
		
		System.out.println("**Subjects**");
		for(String l : subject) {
			System.out.println(l);
		}
		
		System.out.println("**Languages**");
		for(String s : lang) {
			System.out.println(s);
		}
		
		System.out.println("**Address**");
		address.display();
		
		System.out.println("**Result**");
		for(Marks m : marks) {
			m.display();
		}
	}

}
