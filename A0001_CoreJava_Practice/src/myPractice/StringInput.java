package myPractice;

import java.util.*;

public class StringInput {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // here Scanner is class, sc is object, new is a keyword to define object
							System.out.println("enter name");					// and scanner is a non primitive datatype in java.
		String name = sc.nextLine(); // if we didnt write Line(nextLine) then it will only take one single token.
		System.out.println("Your name is : " + name);
		sc.close();

	}

}
