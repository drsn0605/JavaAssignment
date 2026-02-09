package OOPS_in_1_shot;

public class Inheritance {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.age = 13;
		s1.name = "Ishan";
		
		Student s2 = new Student(12,"parth");
		
		s1.walk();
		s1.speak();
	}

}
 
class Student2 extends Student{

	public Student2(int age, String name) {
		super(age, name);
		// TODO Auto-generated constructor stub
	}     //inheritance
	
}

class Student {
	int age;
	String name;
	
//	public Student() {
//		System.out.println("cntr");
//	}
	
	public Student(int age, String name) {
//		System.out.println("ctr2");
		this.age = age;
		this.name = name;
	}
	
	void walk() {
		System.out.println(name + " is walking.");
	}
	
	void speak() {
		System.out.println(name + " is speaking.");
	}
	
}