package CollectionInterface;

import java.util.ArrayList;
import java.util.Iterator;

public class C03_ArrayList {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(10);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(0);
		System.out.println(list);
		
		//iterate using for loop
		for(int i=0; i<list.size(); i++) {
			System.out.println("num is : " + list.get(i));
		}
		
		//iterate using for each
		for(Integer nm : list) {
			System.out.println("number is: "+ nm);
		}
		
		//iterate using Iterator
		Iterator<Integer> num = list.iterator();
		while(num.hasNext()) {
			System.out.println("num is :"+ num.next());
		}
	}

}
