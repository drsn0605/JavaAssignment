package Recursion;

public class SumofNnums {
	public static void printSum(int i, int n, int sum) {

		if (i == n) {
			sum += i;
			System.out.println(sum);
			return;
		}
		sum += i; // work - 1st step
		printSum(i + 1, n, sum); // recursive cell
	}

	public static void main(String args[]) {
		printSum(1, 5, 0);
	}

	// memory stack flow
//	public static void printSum(int i, int n, int sum) {
//
//		if (i == n) {
//			sum += i;
//			System.out.println(sum);
//			return;
//		}
//		sum += i; // work - 1st step
//		printSum(i+1, n, sum); //recursive cell
//		System.out.println(i);
//	}
//
//	public static void main(String args[]) {
//		printSum(1, 5, 0);
//	}

}
