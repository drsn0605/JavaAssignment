package collection;

import java.util.Iterator;
import java.util.TreeSet;

public class C005_TreeSet {    //sort
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(700);
		set.add(20);
		set.add(30);
		set.add(40);
		set.add(10);

		Iterator<Integer> itr = set.iterator();
//		Iterator<Integer> itr = set.descendingIterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

	}
}
