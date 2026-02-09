package CollectionInterface;

import java.util.ArrayDeque;

public class C06_ArrayDeque {
	public static void main(String[] args) {
		
		ArrayDeque<Integer> adq = new ArrayDeque<>();
		adq.offer(23);
		adq.offerFirst(12);
		adq.offerLast(40);
		adq.offer(26);
		
		System.out.println(adq);
		
//		System.out.println(adq.peek());
//		System.out.println(adq.peekFirst());
//		System.out.println(adq.peekLast());
		
		System.out.println(adq.poll());
		System.out.println(adq);
		
		System.out.println(adq.pollFirst());
		System.out.println(adq);
		
		System.out.println(adq.pollLast());
		System.out.println(adq);
	}

}
