package myPractice;

public class recursion {
	
	//print numbers 5 to 1
//	public static void printNumb(int n) {
//		if (n==0) {
//			return;
//		}
//		System.out.println(n);
//		printNumb(n-1);
//		
//	}
//	
//	public static void main(String[] args) {
//		int n = 5;
//		printNumb(n);
//		
//	}
	
	//print numbers 1 to 5
	public static void printNumb(int n) {
		if (n==6) {
			return;
		}
		System.out.println(n);
		printNumb(n+1);
		
	}
	
	public static void main(String[] args) {
		int n = 1;
		printNumb(n);
		
	}


}
