package com;

import java.util.List;
import java.util.Set;

public class Student2 {
	int id;
	String name;
	String email;
	List<String> sub;
	Set<String> lang;
	
	Address address;
	
	List<Marks> marks;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
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
	public List<String> getSub() {
		return sub;
	}
	public void setSub(List<String> sub) {
		this.sub = sub;
	}
	public Set<String> getLang() {
		return lang;
	}
	public void setLang(Set<String> lang) {
		this.lang = lang;
	}
	
	public List<Marks> getMarks() {
		return marks;
	}
	public void setMarks(List<Marks> marks) {
		this.marks = marks;
	}
	
	
	public void display() {
		System.out.println(id+" "+name+" "+email+" ");
		
		System.out.println("---Subjects---");
		for(String l : sub) {
			System.out.println(l);
		}
		
		System.out.println("---Language---");
		for(String s : lang) {
			System.out.println(s);
		}
		
		System.out.println("---Address---");
		address.display();
		
		System.out.println("---Marks---");
		for(Marks m : marks) {
			m.display();
		}
	}
}
