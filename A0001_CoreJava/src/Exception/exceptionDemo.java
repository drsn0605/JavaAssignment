package Exception;

public class exceptionDemo {
	public static void main(String[] args) {

		System.out.println("program started..");

//		try {
//			int a = 10;
//			int b = a / 0;
//			System.out.println(b);
//		} catch (ArithmeticException e) {
//			e.printStackTrace();
//		}

		try {
			int a[] = new int[5];
			a[5] = 28;
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}

		System.out.println("program ended..");
		
		// here ArithmeticException and ArrayIndexOutOfBoundsException are subclass of Exception class(parent class).
	}

}
