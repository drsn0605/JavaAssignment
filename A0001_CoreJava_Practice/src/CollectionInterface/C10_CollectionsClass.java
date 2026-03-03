package CollectionInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class C10_CollectionsClass {
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		list.add(34);
		list.add(48);
		list.add(98);
		list.add(12);
		
//		System.out.println(list);
//		Collections.sort(list);
		Collections.sort(list, Comparator.reverseOrder());
		
		System.out.println(list);
	}

}
