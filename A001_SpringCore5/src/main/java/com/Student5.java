package com;

import java.util.List;
import java.util.Set;

public class Student5 {
	int id;
	String name;
	String email;
	String gender;
	
	List<String> subject;
	Set<String> language;
	
	Address adrs;
	
	List<Marks> marks;
	
	public List<Marks> getMarks() {
		return marks;
	}
	public void setMarks(List<Marks> marks) {
		this.marks = marks;
	}
	public Address getAdrs() {
		return adrs;
	}
	public void setAdrs(Address adrs) {
		this.adrs = adrs;
	}
	public List<String> getSubject() {
		return subject;
	}
	public void setSubject(List<String> subject) {
		this.subject = subject;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void display() {
		System.out.println(id+" "+name+" "+email+" "+gender+" ");
		
		System.out.println(" -> Subjects :");
		for(String l : subject) {
			System.out.println(l);
		}
		
		System.out.println(" -> Language :");
		for(String s : language) {
			System.out.println(s);
		}
		
		System.out.println(" -> Address :");
		adrs.display();
		
		System.out.println(" -> Result :");
		for(Marks m : marks) {
			m.display();
		}
	}
}
