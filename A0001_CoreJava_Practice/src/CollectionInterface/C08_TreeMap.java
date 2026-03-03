package CollectionInterface;

import java.util.Map;
import java.util.TreeMap;

public class C08_TreeMap {
	public static void main(String[] args) {
		Map<String, Integer> numb = new TreeMap<>();
		numb.put("One", 1);
		numb.put("Two", 2);
		numb.put("Three", 3);
		numb.put("Four", 4);
		numb.put("Six", 6);
		System.out.println(numb);
	}
}
