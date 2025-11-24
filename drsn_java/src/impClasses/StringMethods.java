package impClasses;

import java.util.Iterator;

public class StringMethods {
	public static void main(String[] args) {

		String str = " Sun rises in East  ";

//		System.out.println(str.length());
//		System.out.println(str.toUpperCase());
//		System.out.println(str.toLowerCase());
//		System.out.println(str.charAt(5));
//		System.out.println(str.indexOf('i'));
//		System.out.println(str.lastIndexOf('s'));
//		System.out.println(str.startsWith("S"));
//		System.out.println(str.endsWith("r"));
//		System.out.println(str.substring(5, 9));
//		System.out.println(str.replace("S", "M"));
//		System.out.println(str.trim());  //remove the space before and after the string.

		String words[] = str.split(" ");  //words of string stores in words[] array. 
		for (int i = 0; i < words.length; i++) {
			System.out.println(words[i]);
		}

		System.out.println("*******************");

		char ch[] = str.toCharArray();  //separate each character
		for (int i = 0; i < ch.length; i++) {
			System.out.println(ch[i]);
		}
		
		System.out.println("*******************");
		
		byte b[] = str.getBytes(); //gives Ascii value.
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}
}
