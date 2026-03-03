package OOPS_04;

public class AbstractKeyword {
	public static void main(String[] args) {
//		Vehicle v1 = new Vehicle();
		Car c1 = new Car();    //we cannot make object of abstract class but we can make object of his child class.
		c1.accelarate();
		c1.brakes(4);
		c1.honks();  //yaha pe Vehicle wala honks chalega. Agar hum Car class me override nahi karenge to.
		//agar override karenge to Car wala honks chalega.
		c1.honks();
	}

}

//hum chahte hai ki vehicle ki properties and methods- Car ko implement karna hi karna pade,
//so hum vehicle ko Abstract bana denge & wo methods ko bhi Abstract bana denge.
//Ab Car ko Vehicle ki sari methods and properties ko implement karna hi padega.
//Otherwise hum Car ko bhi initialize nahi kar payenge. Otherwise Car hame Compiletime error de degi.

abstract class Vehicle{
	
	abstract void accelarate();      //Abstract method
	abstract int brakes(int wheels);       //Abstract method
	void honks() {      //Non-abstract method (also known as concrete method) - isko override karna compulsory nahi hai.
		System.out.println("Vehicle honks");
	}
}

class Car extends Vehicle{    //or we can also make this Car class abstract.
//abstract class Car extends Vehicle{

	@Override   
	void accelarate() {
		System.out.println("Car is accelarating");
	}

	@Override
	int brakes(int wheels) {
		System.out.println("push break to stop car");
		return wheels;	
	}
	
	void honks() {
		System.out.println("Car honks");
	}
	
}