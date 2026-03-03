package OOPS_01;

// Constructor - "Constructor are invoked implicitly, when we instantiate objects."
// 2 rules - 1. name of constructor = name of class 2. Constructor does not have any return type.
// A constructor cannot be Abstract, Static or Final.

// Imp - A constructor can be Overloaded but cannot be Overridden. 

class Complex1 {
	int a,b;   //properties
	
//	public Complex1() {  //default constructor
//		a = 0;
//		b = 0;
//	}
	
	public Complex1() {  //constructor
		a = 4;
		b = 7;
		System.out.println("Creating a new object");
	}	
	void print() {   //behavior
		System.out.println(a+"+"+b+"i");
	}
}

public class Constructors {
	public static void main(String[] args) {
		
		Complex1 num1 = new Complex1();
		Complex1 num2 = new Complex1();
		num1.print();
		num2.print();
	}

}

