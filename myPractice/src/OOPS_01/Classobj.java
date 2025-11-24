package OOPS_01;

//Class - Class is a non primitive data type.
class Dog{
	String name;  //Properties - we are creating variables.
	int age;
	String colour;
	
	void walk() {  //Behavior - we are defining functions. 
		System.out.println(name+" is walking");
	}
	void bark() {
		System.out.println("Dog is barking");
	}
}

class Cat{
	String name;   //properties
	int age;
	String colour;
	
	void run() {   //behavior
		System.out.println("Cat is running");
	}
}

public class Classobj {   //we can create multiple class but public class must be only once.
	public static void main(String[] args) {
		Dog d1 = new Dog();
		d1.name = "Tommy";
		d1.colour = "Black";
		d1.walk();
		d1.bark();
		
		Dog d2 = new Dog();
		d2.name = "Lio";
		d2.colour = "Red";
		d2.bark();
		d2.walk();
	}

}


