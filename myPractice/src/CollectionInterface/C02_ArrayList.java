package CollectionInterface;

import java.util.ArrayList;
import java.util.Iterator;

public class C02_ArrayList {
	public static void main(String[] args) {
		
		ArrayList<String> al = new ArrayList<>();
		al.add("darshan");
		al.add("rahul");
		al.add("deep");
		al.add("jay");
		al.add("meet");
		System.out.println(al);
		
//		al.remove(1);
//		System.out.println(al);
		
		//using for loop
		for(int i=0; i<al.size(); i++) {
			System.out.println("student : "+ al.get(i));
		}
		
		//using for each 
		for(String std : al) {
			System.out.println("std :" + std);
		}
		
		//using iterator
		Iterator<String> name = al.iterator();
		while(name.hasNext()) {
			System.out.println("student : "+ name.next());
		}
	}
}
