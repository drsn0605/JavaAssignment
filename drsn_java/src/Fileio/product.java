package Fileio;

import java.io.Serializable;

public class product implements Serializable {
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
	int id = 1234;
	String name = "Clothes";
	String brand = "Denim";
	
	public void display() {
		System.out.println(id+" "+name+" "+brand+" ");
	}
	

}
