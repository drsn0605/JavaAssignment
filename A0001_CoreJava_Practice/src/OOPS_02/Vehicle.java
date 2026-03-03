package OOPS_02;

public class Vehicle {   //vehicle - parent class
	int wheelsCount;   //properties
	String model;
	
	void start() {    //behavior
		System.out.println("Vehicle is starting");
	}
	
	Vehicle(){     //constructor
		System.out.println("Vehicle is being created");
	}
	
	Vehicle(int wheelsCount){
		this.wheelsCount = wheelsCount;
		System.out.println("Vehicle has wheels also");
	}
}
