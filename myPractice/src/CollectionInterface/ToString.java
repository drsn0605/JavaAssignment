package CollectionInterface;

class A{
	int id = 10;

	@Override
	public String toString() {
		return "Hello";
	}

	
	
}

public class ToString {
	public static void main(String[] args) {
		A a = new A();
		System.out.println(a);
	}

}
