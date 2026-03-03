package CollectionInterface;

import java.util.ArrayList;
import java.util.Iterator;

public class C04_ArrayList {
	public static void main(String[] args) {
		ArrayList<String> li = new ArrayList<>();
		li.add("abs");
		li.add("abs");
		li.add("ajs");
		li.add("aks");
		li.add("abp");
		li.add("xzc");
		System.out.println(li);
		
		//iterate using for loop
		for(int i=0; i<li.size(); i++) {
			System.out.println("code is :"+ li.get(i));
		}
		
		//iterate using for each
		for(String cd : li) {
			System.out.println("code : " + cd);
		}
		
		//iterate using Iterator
		Iterator<String> code = li.iterator();
		while(code.hasNext()) {
			System.out.println("cd is:"+ code.next());
		}
	}	
}
