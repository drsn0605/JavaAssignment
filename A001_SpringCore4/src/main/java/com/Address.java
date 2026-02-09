package com;

public class Address {
	String city;
	String dis;
	String state;
	String country;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDis() {
		return dis;
	}
	public void setDis(String dis) {
		this.dis = dis;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public void display() {
		System.out.println("city : "+city+","+" "+"District : "+dis+","+" "+"State : "+state+","+" "+"Country : "+country);
	}
	
}
