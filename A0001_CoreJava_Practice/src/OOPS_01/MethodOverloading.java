package OOPS_01;

// MethodOverloading - same name methods inside the same class but have different parameters.
// It is also known as 'Compile-time Polymorphism'. 

// Definition - "Two or more methods can have the same name inside the same class - if they accept different parameters."

// Method overloading is achieved by either - 1. changing the number of arguments 2. by changing the data-type of arguments.

// it is not method overloading, if we only change the return type of methods. 
// There must be differences in the number of parameters. 

class Greet{
	void greetings() {  
		System.out.println("Hello, Good morining");
	}
	
//	int greetings() {  - this is not valid bcoz return type is different but parameter are not different.
//		return 0;
//	}
	
	void greetings(String name) {
		System.out.println("Hello, "+name+" Good morining");
	}
	
//	void greetings(String surname) - this is also not valid. Here parameters are different but the type of parameter is same.
//	So that system cannot able to differentiate them. 

	void greetings(String name, int age) {
		System.out.println("Hello, "+name+" Good morning.Your age is "+age);
	}
	
	void greetings(String name,int age,int count) {
		for (int i=1;i<count;i++) {
			System.out.println("Hello, "+name+" Good morning.Your age is "+age);
		}
	}
}

public class MethodOverloading {
	public static void main(String[] args) {
		Greet obj = new Greet();
		obj.greetings();
		obj.greetings("Darshan");
		obj.greetings("Sanat", 24);
		obj.greetings("Rahul", 20, 5);
	}

}

