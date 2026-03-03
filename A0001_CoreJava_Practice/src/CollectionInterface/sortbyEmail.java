package CollectionInterface;

import java.util.Comparator;

public class sortbyEmail implements Comparator<User2> {

	@Override
	public int compare(User2 o1, User2 o2) {
		// TODO Auto-generated method stub
		return -o2.email.compareTo(o1.email);
	}

}
