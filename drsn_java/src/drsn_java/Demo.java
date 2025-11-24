package drsn_java;

public class Demo {
	public static void main(String[] args) {
		System.out.println("hello");
		
		int a = 1342134;
		String name = "darshan";
		String firstName = "hsdkjsk";
		String Lastname = "ksvkkv";  // should not start with uppercase
		
		byte b = 127;
		short s = 3423;
		int i = 4545;
		long l = 876586294386l; // here at the end we have to write l in long datatype
		
		float f = 34.562f;
		double d = 23424.235235;
		
		char ch = 4353;
		boolean bool = true;
		
		String st = "fvjabava";
		
		//widining - implicit 
		int m = 10;
		long n = m;
		
		//narrowing - explicit 
		long x = 24354253l;
		int y = (int) x;
		System.out.println(y);
	}

}
