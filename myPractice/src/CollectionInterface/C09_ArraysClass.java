package CollectionInterface;

import java.util.Arrays;

public class C09_ArraysClass {
	public static void main(String[] args) {
		
		Integer[] numb = {10,32,40,5,26,20};
		Arrays.sort(numb);
		
		for(int i:numb) {
			System.out.println(i);
		}
	}

}
