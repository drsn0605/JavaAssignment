package com;

public class Marks {
	String subj;
	String mrk;
	public String getSubj() {
		return subj;
	}
	public void setSubj(String subj) {
		this.subj = subj;
	}
	public String getMrk() {
		return mrk;
	}
	public void setMrk(String mrk) {
		this.mrk = mrk;
	}
	
	public void display() {
		System.out.println(subj+" "+mrk);
	}
}
