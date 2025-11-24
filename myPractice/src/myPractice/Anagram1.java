package myPractice;

import java.util.Arrays;

public class Anagram1 {
	public static void main(String[] args) {
		String a = new String("keep");
		char a1[] = a.toCharArray();
		for (int i = 0; i < a1.length; i++) {
			Arrays.sort(a1);
			System.out.print(a1[i]);
		}
		System.out.println();

		String b = new String("peek");
		char b1[] = b.toCharArray();
		for (int i = 0; i < b1.length; i++) {
			Arrays.sort(b1);
			System.out.print(b1[i]);
		}
		System.out.println();

//		boolean result = Arrays.equals(a1, b1);
		if (a1==b1) {   //
			System.out.println("Anagram");
		} else {
			System.out.println("Not Anagram");
		}
	}

}
