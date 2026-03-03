package collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ProductCollection {
	public static void main(String[] args) {
		
		ArrayList<Product> al = new ArrayList<>();
		al.add(new Product(1,"Book",50,5));
		al.add(new Product(2,"Textbook",80,4));
		al.add(new Product(3,"Pencil",10,10));
		al.add(new Product(4,"Eraser",5,5));
		al.add(new Product(5,"Pen",20,20));
		
		Iterator<Product> itr = al.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
