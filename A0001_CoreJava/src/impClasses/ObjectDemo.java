package impClasses;

class A {
	int id = 10;

	@Override
	public String toString() {

		return "Hello" + id;
	}
}

public class ObjectDemo {
	public static void main(String[] args) {

		A a = new A();

		System.out.println(a);
	}

}
