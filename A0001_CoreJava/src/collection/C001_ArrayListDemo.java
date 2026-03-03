package collection;

import java.util.ArrayList;

public class C001_ArrayListDemo {
	public static void main(String[] args) {
		
		//default size : 10
		//new size = old size * 3 / 2 + 1 = 16
		ArrayList<String> al = new ArrayList<String>();
		al.add("Java");
		al.add("Php");
		al.add("Android");
		al.add("SQL");
		al.add("Java");   //we can add duplicate value also
		al.add(null);  //we can add null value also
		
		al.add(1,"Oracle");  //to add Oracle at 1st index
		al.set(1,"Oracle");   //to replace Php to Oracle at 1st index
//		al.remove(1);    //to remove 1st index element
		
		System.out.println(al.size());   //give size of ArrayList
		System.out.println(al.get(0));
		System.out.println(al.contains("python"));
		
		//Enhanced for loop or. For-each loop(used when we have collection)
		for(String s:al) {
			System.out.println(s);
		}
	}

}
