package collection;

import java.util.Enumeration;
import java.util.Vector;

//this is not imp for interview

public class C007_Vector {   //allow duplicate values
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();
		v.addElement(70);
		v.addElement(20);
		v.addElement(30);
		v.addElement(10);
		
		
		Enumeration<Integer> en = v.elements();
		while(en.hasMoreElements()) {
			System.out.println(en.nextElement());
		}
		
	}

}
