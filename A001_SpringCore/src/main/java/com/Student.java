package com;

import java.util.List;
import java.util.Set;

public class Student {
	
	//we can add the data of variable.
	int id;
	String name;
	String email;
	List<String> subjects;    //list - allow duplicates
	Set<String> languages;    //set - dont allow duplicates
	
	//we can add the data of whole class.
	Address address;
	
	//we can add the list of data - of a class also.
	List<Marks> marks;
	
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
	
	public List<String> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}
	public Set<String> getLanguages() {
		return languages;
	}
	public void setLanguages(Set<String> languages) {
		this.languages = languages;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public List<Marks> getMarks() {
		return marks;
	}
	public void setMarks(List<Marks> marks) {
		this.marks = marks;
	}
	public void display() {
		System.out.println(id+" "+name+" "+email+" ");
		
		System.out.println("--Subjects--");
		for(String l : subjects) {
			System.out.println(l);
		}
		
		System.out.println("--Languages--");
		for(String s : languages) {
			System.out.println(s);
		}
		
		System.out.println("--Address--");
		address.display();
		
		System.out.println("--Marks--");
		for(Marks m : marks) {
			m.display();    //why ? 
			//suppose we have 3 subjects. 
			//So what we have to do for 3 subjects ? -> we have to make 3 bean for 3 subjects. in xml file. 
		}
	}
	
}
