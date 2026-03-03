package OOPS_02;

public class Car extends Vehicle { // car - child class
	void start() {

		super.start(); // super keyword- invoke the method of immediate parent class(which is vehicle).

		System.out.println(this.model + " Car is starting");
		System.out.println(this); // output - Inheritance.Car@6f539caf (package name . class name @ object
									// reference)
	}

	Car() {
		super(8);
		System.out.println("Car is being created");
	}

	public static void main(String[] args) {
		Car obj = new Car();
		System.out.println(obj.wheelsCount);
		obj.wheelsCount = 4;
		obj.model = "Top";
		obj.start();
		System.out.println(obj.wheelsCount);

	}
}
