package CollectionInterface;

import java.util.Comparator;

public class sortbyName implements Comparator<User2>{

	@Override
	public int compare(User2 o1, User2 o2) {
		
		return o1.name.compareTo(o2.name);
	}
	

}
