package CollectionInterface;

import java.util.ArrayList;
import java.util.Collections;

public class User2Collection {
	public static void main(String[] args) {
		
		ArrayList<User2> al = new ArrayList<>();
		al.add(new User2(10,"Rahul","Zahul@gmail.com"));
		al.add(new User2(1,"Jay","Lay@gmail.com"));
		al.add(new User2(5,"Deep","Aeep@gmail.com"));
		
//		Collections.sort(al);   //default 
//		Collections.sort(al,new sortbyName());    //custom
		Collections.sort(al,new sortbyEmail()); 
		
		for (User2 u : al) {
			System.out.println(u);
		}
		
		
	}

}
