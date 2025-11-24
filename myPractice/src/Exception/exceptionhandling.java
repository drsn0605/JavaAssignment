package Exception;

public class exceptionhandling {
	public static void main(String[] args) {
		try {
			int a = 10;
			int b = a / 0;
			System.out.println(b);
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
	}

}
