package myPractice;

import java.util.HashSet;

public class InterfacePrac2 {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<>();
		hs.add("Java");
		hs.add("Java");
		hs.add("python");
		hs.add("html");
		hs.add(null);
		hs.add(null);
		System.out.println(hs);
	}

}
