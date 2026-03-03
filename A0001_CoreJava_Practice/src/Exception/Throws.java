package Exception;

public class Throws {
	public static void main(String[] args) {
		int a[] = new int[5];

		try {
			getNumberFromArray(a);
		} catch (Exception e) {
			System.out.println("you are trying to access out of bound index");
			System.out.println(e.getMessage());
		}
	}

	static int getNumberFromArray(int a[]) throws ArithmeticException {
		return a[8];
	}

}

//Throws - We use throws keyword in the method declaration to declare the type of exception.
//means, this function might give an exception.
//1.Propagate the exception
//2.followed by the class
//3.it will come with the method body.
