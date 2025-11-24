package collection;

import java.util.HashSet;
import java.util.Iterator;

public class C003_HashSetDemo {    //dose not allow duplicate value
	public static void main(String[] args) {
		
		//default size - 16
		//new size = loadFactor-0.75%
		
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(10);
		set.add(20);
		set.add(30);
		set.add(40);
		set.add(10);
		
		Iterator<Integer> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
