package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class C009_StudentCollection {
	public static void main(String[] args) {
		
//		Student s1 = new Student(1, "drsn", "drsn@gmail.com");
//		
//		ArrayList<Student> al = new ArrayList<Student>();
//		al.add(s1);
		
		ArrayList<Student> al = new ArrayList<Student>();
		al.add(new Student(40,"drsn","drsn@gmail.com"));
		al.add(new Student(20,"Gopal","gopal@gmail.com"));
		al.add(new Student(28,"Om","om@gmail.com"));
		al.add(new Student(10,"Naitik","naitik@gmail.com"));
		
		Collections.sort(al);
		
		Iterator<Student> itr = al.iterator();
		while(itr.hasNext()) {
			
//			Student st = itr.next();
//			st.display();
			
//			Student st = itr.next();
//			System.out.println(st);
			
			System.out.println(itr.next());
		}
		
	}

}
