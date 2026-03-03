package CollectionInterface;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class C05_PriorityQueue {
	public static void main(String[] args) {
		
		Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		pq.offer(40);
		pq.offer(25);
		pq.offer(30);
		pq.offer(12);
		
		
		System.out.println(pq);
	}

}
