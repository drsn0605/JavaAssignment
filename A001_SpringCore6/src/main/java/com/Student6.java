package com;

import java.util.List;
import java.util.Set;

public class Student6 {
	int id;
	String name;
	String email;
	
	List<Long> number;
	Set<String> language;
	
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
	public List<Long> getNumber() {
		return number;
	}
	public void setNumber(List<Long> number) {
		this.number = number;
	}
	public Set<String> getLanguage() {
		return language;
	}
	public void setLanguage(Set<String> language) {
		this.language = language;
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
		
		System.out.println("-> Phone number :");
		for(Long l : number) {
			System.out.println(l);
		}
		
		System.out.println("-> Languages :");
		for(String s : language) {
			System.out.println(s);
		}
		
		System.out.println("-> Address :");
		address.display();
		
		System.out.println("-> Result :");
		for(Marks m : marks) {
			m.display();
		}
	}
}
