package OOPS_01;

public class CustomDatatypeUsingClass {
	public static void main(String[] args) {
		Complex num1 = new Complex();   //object
		num1.a=12;
		num1.b=20;
		num1.print();
	}

}

class Complex{
	int a,b;  //properties
	
	void print(){   //behavior
		System.out.println(a+"+"+b+"i");
	}
}
