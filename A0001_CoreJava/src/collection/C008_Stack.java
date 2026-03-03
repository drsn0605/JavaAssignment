package collection;

import java.util.Stack;

//stack - Lifo (Last in first out)

public class C008_Stack {    //allow duplicate
	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(10);
		st.push(70);
//		st.pop();
		
		System.out.println(st.pop());   //to remove element
//		System.out.println(st.peek());  //to take particular element
		System.out.println("**********");
		
		for(int i : st) {
			System.out.println(i);
		}
	}

}
