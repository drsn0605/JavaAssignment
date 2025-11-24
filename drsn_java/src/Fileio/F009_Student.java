package Fileio;

import java.io.Serializable;

public class F009_Student implements Serializable {
	int id = 10;    //properties
	String name = "test";
	transient String email = "test@gmail.com";  //to hide email we use transient.
	
	public void display() {   //behavior
		System.out.println(id+" "+name+" "+email);
	}


}
