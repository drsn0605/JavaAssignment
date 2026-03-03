package OOPS_in_1_shot;

public class MainClass {
	public static void main(String[] args) {
//		System.out.println("hello");
		Person p1 = new Person();
		p1.name = "darshan";
		p1.age = 24;
//		System.out.println(p1.age);   
//		System.out.println(p1.name);
		
		Person p2 = new Person(26,"Rahul");    //properties contruct hone time hi initialize ho jayegi.
//		p2.age = 26;
//		p2.name = "rahul";
//		System.out.println(p2.name + " " + p2.age);
		
//		p1.walk();
//		p2.eat();
//		p2.walk(30);
//		p1.walk(12);
		System.out.println("123");
//		System.out.println(Person.count);
	}
}

class Person{
	String name;
	int age;
	static int count;  //static means, usko hm sirf object ke through access nahi kar sakte, Class ke through bhi access kar sakte hai. [ It is not depend on class].
	
	public Person() {    //constructor
		count = count + 1;  //count++
 		System.out.println("done!");
 		System.out.println("xyz");
	}
	
//	//we can overload the constructor, by this way-
//	public Person(int newAge, String newName) {
//		this();    //this() - ye person() constructor ko call karega. 
//		age = newAge;
//		name = newName;
//		System.out.println("drsn");
//	}
	
	//we can overload the constructor, by this way-
		public Person(int age, String name) {
			this();    //this() - ye person() constructor ko call karega. 
			this.age = age;
			this.name = name;
		}
	
	void walk() {
		System.out.println(name + " is walking");
	}

	void eat() {
		System.out.println(name + " is eating");
	}
	
	void walk(int steps) {    //here steps is argument
		System.out.println(name + " walked " + steps + " steps.");
	}
}
