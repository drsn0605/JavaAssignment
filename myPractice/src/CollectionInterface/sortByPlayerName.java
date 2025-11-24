package CollectionInterface;

import java.util.Comparator;

public class sortByPlayerName implements Comparator<Player> {

	@Override
	public int compare(Player o1, Player o2) {
		// TODO Auto-generated method stub
		return -o2.name.compareTo(o1.name);
	}

}
