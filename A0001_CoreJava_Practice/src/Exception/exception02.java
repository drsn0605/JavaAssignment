package Exception;

public class exception02 {
	public static void main(String[] args) {

		int a[] = new int[5];

		try {

			int i = 5 / 0;
			System.out.println(a[6]);

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Tried to access the out of bound element.");
		} catch (ArithmeticException e) {
			System.out.println(e);
			System.out.println(e.getStackTrace()); // it will show from where you are getting error
			System.out.println(e.getMessage());
		}

		System.out.println("agdjhbasjvb");
	}

}
