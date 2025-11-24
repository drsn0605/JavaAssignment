package collection;

import java.util.LinkedList;

public class C006_LinkedList {
	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.add(10);
		l.add(20);
		l.add(30);
		l.add(10);
		l.add(70);
		l.add(20);
		l.addFirst(5656);
		
		for(int i:l) {
			System.out.println(i);
		}
	}

}
