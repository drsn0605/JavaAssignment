package CollectionInterface;

import java.util.ArrayList;
import java.util.Iterator;

public class C01_ArrayList {
	public static void main(String[] args) {
		ArrayList<Integer> al1 = new ArrayList();
		al1.add(10);
		al1.add(20);
		al1.add(30);
		al1.add(40);
		al1.add(50);
		al1.add(60);
		al1.add(70);
		
//		System.out.println(al1);
//		al1.add(2,100);
//		System.out.println(al1);
		
//		ArrayList<Integer> newal1 = new ArrayList();
//		newal1.add(90);
//		newal1.add(80);
//		newal1.add(70);
//		
//		al1.addAll(newal1);
//		System.out.println(al1);
//		
//		newal1.remove(Integer.valueOf(70));  //to remove particular element.
//		System.out.println(newal1);
//		
//		newal1.clear();    //to clear the whole list.
//		System.out.println(newal1);
		
//		al1.set(2, 3000);
//		System.out.println(al1);
		
		for(int i = 0; i< al1.size();i++) {
			System.out.println("element is : " + al1.get(i));
		}
		
		for(Integer element : al1) {
			System.out.println("element : " + element);
		}
		
		Iterator<Integer> it = al1.iterator();
		while(it.hasNext()) {
			System.out.println("element is : " + it.next());
		}
		
	}

}
