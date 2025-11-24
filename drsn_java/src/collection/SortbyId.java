package collection;

import java.util.Comparator;

public class SortbyId implements Comparator<User>{

	@Override
	public int compare(User o1, User o2) {
		
		int currentId = o1.id;
		int newId = o2.id;
		int i = 0;
		if(currentId>newId) {
			i = 1;
		}
		else if(currentId<newId) {
			i = -1;
		} 
		else {
			i = 0;
		}
			
		return i;
	}
	

}
