package OOPS_01;

class Complex4{
	int a,b;
	
	public Complex4(int real,int imaginary) {
		a = real;
		b = imaginary;
	}
	
	public Complex4(int real) {
		a = real;
		b = 12;   //if i don't write b = 12, system will take default value b = 0.
	}
	
	void print() {
		System.out.println(a+"+"+b+"i");
	}
	
	Complex4 add(Complex4 num2) {   //here Complex4 is a non primitive datatype.
		Complex4 newNumb = new Complex4(a+num2.a,b+num2.b);
		return newNumb;
	}
}

public class ConstructorOverloading {
	public static void main(String[] args) {
		Complex4 num1 = new Complex4(4,8);
		Complex4 num2 = new Complex4(5,7);
		num1.print();
		num2.print();
		
		System.out.println("Adding two numbers");
		Complex4 result = num1.add(num2);
		result.print();
	}

}
