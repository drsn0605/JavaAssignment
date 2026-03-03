package CollectionInterface;

import java.util.HashMap;
import java.util.Map;

public class C07_HashMap {
	public static void main(String[] args) {
		
		Map<String, Integer> numbers = new HashMap<>();
		numbers.put("One", 1);
		numbers.put("two", 2);
		numbers.put("three", 3);
		numbers.put("four", 4);
//		System.out.println(numbers);
//		numbers.put("two", 5);
//		System.out.println(numbers);
		
		for(Map.Entry<String, Integer> e : numbers.entrySet()) {
//			System.out.println(e);
//			System.out.println(e.getKey());
			System.out.println(e.getValue());
		}
		
		System.out.println("___________________");
		
		for(String key : numbers.keySet()) {
			System.out.println(key);
		}
	}

}
