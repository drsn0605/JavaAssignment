package OOPS_01;

//using constructor:
class Student01 {
	int id;
	String name;

	Student01(int i, String n) {
		id = i;
		name = n;
	}

	void display() {
		System.out.println(id + " " + name);
	}
}

public class CodeWithoutConstructor {
	public static void main(String[] args) {
		Student01 s1 = new Student01(101,"Darshan");
		s1.display();
	}

}


//without constructor:
//class Student01 {
//	int id;
//	String name;
//
//	void setData(int i, String n) {
//		id = i;    //if i=id; &
//		name = n;   //n=name;  then it will give (0 null) as an output.
//	}
//
//	void display() {
//		System.out.println(id + " " + name);
//	}
//}
//
//public class ConstructorStudent {
//	public static void main(String[] args) {
//		Student01 s1 = new Student01();
//		s1.setData(101, "darshan");
//		s1.display();
//	}
//}
