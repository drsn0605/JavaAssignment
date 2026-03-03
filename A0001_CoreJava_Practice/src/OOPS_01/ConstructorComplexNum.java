package OOPS_01;

class Complex3{
	int a,b;   //properties
	
	public Complex3(int real,int imaginary) {
		a = real;     
		b = imaginary;
		System.out.println("Creating a new object");
	}
	
	void print() {   //behavior  
		System.out.println(a+"+"+b+"i");
	}
}

public class ConstructorComplexNum {
	public static void main(String[] args) {
		Complex3 num1 = new Complex3(2,6);
		num1.print();
	}

}
