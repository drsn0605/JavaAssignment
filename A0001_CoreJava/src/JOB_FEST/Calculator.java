package JOB_FEST;

import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
	
		
		System.out.println("--Calculator using if-else--");
		System.out.println("Enter first number :");
		int m = sc.nextInt();
		
		System.out.println("Enter second number :");
		int n = sc.nextInt();
		
		System.out.println("Enter operation(+,-,*,/,%,) + type ! to quit. : ");
		char x = sc.next().charAt(0);
		
		int ans = 0;
		
		if(x=='+') {
			ans = m + n;
			System.out.println(ans);
		}
		else if(x=='-') {
			ans = m - n;
			System.out.println(ans);
		}
		else if(x=='*') {
			ans = m * n;
			System.out.println(ans);
		}
		else if(x=='/') {
			if(n!=0) {
				ans = m / n;
				System.out.println(ans);
			}
			else {
				System.out.println("Division by zero is not allowed.");
			}
		}
		else if(x=='%') {
			if(n!=0) {
				ans = m % n;
				System.out.println(ans);
			}
			else {
				System.out.println("Division by zero is not allowed.");
			}
		}
		
	}
}
