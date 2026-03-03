package collection;

import java.util.HashMap;

public class CharCounter {
	public static void main(String[] args) {
		String str = "my name is Darshan";

		HashMap<Character, Integer> map = new HashMap<>();

//		String words[] = str.split(" ");
		char arr[] = str.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			if (map.get(arr[i]) == null) {
				map.put(arr[i], 1);
			} else {
				int value = map.get(arr[i]);
				value++;
				map.put(arr[i], value);
			}
		}
		System.out.println(map);
	}
}
