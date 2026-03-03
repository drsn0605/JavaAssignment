package collection;

import java.util.ArrayList;
import java.util.Collections;

public class UserCollection {
	public static void main(String[] args) {
		ArrayList<User> al = new ArrayList<>();
		al.add(new User(51,"Naitik","fasdf@gmail.com"));
		al.add(new User(10,"Parth","iwejfoiq@gmail.com"));
		al.add(new User(12,"Neel","svmaksj@gmail.com"));
		
		Collections.sort(al, new SortbyId());
		
		for(User u : al) {
			System.out.println(u);
		}
	}

}
