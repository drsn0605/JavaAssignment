package collection;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class C004_LinkedHashSet {      //print as usual, does not allow duplicate
	public static void main(String[] args) {
		
		LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
		set.add(500);
		set.add(20);
		set.add(30);
		set.add(40);
		set.add(20);
		
		Iterator<Integer> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
