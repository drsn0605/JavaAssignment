package myPractice;

class Student{
	int id;
	String name;
	
	void display() {
		System.out.println(id+" "+name);
	}
}

public class Class_Object {
	public static void main(String[] args) {
		Student s1 = new Student();
		Student s2 = new Student();
		
		s1.id = 101;
		s1.name = "darshan";
		s2.id = 102;
		s2.name = "deep";
		
		s1.display();
		s2.display();
	}

}
