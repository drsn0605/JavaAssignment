package OOPS_03;

//Static methods cannot access non-static variables directly.

class Demo{
	static void show() {
		System.out.println("Static method");
	}
}

public class Static02 {
	public static void main(String[] args) {
		Demo.show();      //No object required
	}
}
