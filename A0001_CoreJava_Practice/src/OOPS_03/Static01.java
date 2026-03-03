package OOPS_03;

//Only one copy of static variable exists in memory.Here static variable is school.

class Student {
	static String school = "AB School";
	String name;
}

public class Static01 {
	public static void main(String[] args) {
//		Static01 s1 = new Static01();
//		Static01 s2 = new Static01();
		System.out.println(Student.school); // same for all students

	}
}
