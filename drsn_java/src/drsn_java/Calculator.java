package drsn_java;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("-> CALCULATOR(USING IF ELSE)");
		
		System.out.println("Enter first number : ");
		int m = sc.nextInt();
		
		System.out.println("Enter second number : ");
		int n = sc.nextInt();
		
		System.out.println("Choose an operator (+,-,*,/,%) : ");
		char x = sc.next().charAt(0);
		
		int ans = 0;
		if(x == '+') {
			ans = m + n;
			System.out.println("result : "+ans);
		}
		else if(x == '-') {
			ans = m - n;
			System.out.println("result : "+ans);	
		}
		else if(x == '*') {
			ans = m * n;
			System.out.println("result : "+ans);
		}
		else if(x == '/') {
			if(n != 0) {
				ans = m / n;
				System.out.println("result : "+ans);
			}
			else {
				System.out.println("Error: Division by zero is not allowed.");
			}	
		}
		else if(x == '%') {
			if(n != 0) {
				ans = m % n;
				System.out.println("result : "+ans);
			}
			else {
				System.out.println("Error: Division by zero is not allowed.");
			}
		}
		
		else {
			System.out.println("invalid operator");
		}

	}

}
