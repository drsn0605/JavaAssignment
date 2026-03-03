package OOPS_in_1_shot;

public class test {
	public static void main(String[] args) {
		
//		int args = 12;
//		System.out.println(args == null);
//		System.out.println(args.length);
//		char d = 'A';
//		byte b = 10;
//		System.out.println(b);
//		System.out.println(d);
		
		byte b = 65;
		char c = 65;

//		System.out.println(b); // 65
//		System.out.println(c); // A
		
		Student1 st = new Student1();
		System.out.println(st.name);
		System.out.println(st.age);

	}
}

class Student1 {
    String name;   // object reference (instance variable)
    Integer age;   // object reference (wrapper class)
    
    
}
